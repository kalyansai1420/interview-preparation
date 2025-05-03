package com.example.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.User;

import io.ipinfo.api.IPinfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Double> locationData, HttpServletRequest request,
            HttpSession session, HttpServletResponse response) {
        Double latitude = locationData.get("latitude");
        Double longitude = locationData.get("longitude");

        if (latitude != null && longitude != null) {
            User user = new User();
            user.setLatitude(latitude);
            user.setLongitude(longitude);
            session.setAttribute("loggedInUser", user);
            Map<String, String> responseData = new HashMap<>();
            responseData.put("latitude", String.valueOf(latitude));
            responseData.put("longitude", String.valueOf(longitude));
            logger.info("User logged in with provided coordinates. Session ID: {}", session.getId());
            logSessionAttributes(session);
            return ResponseEntity.ok(responseData);
        } else {
            // Fallback to IP-based location if frontend didn't provide it
            String ip = request.getHeader("X-Forwarded-For");
            if (ip == null) {
                ip = request.getRemoteAddr();
            }
            IPinfo ipInfo = new IPinfo.Builder()
                    .setToken("e6972f0c3ff654") // Replace with your token
                    .build();
            try {
                IPResponse ipInfoResponse  = ipInfo.lookupIP(ip);
                String ipLatitude = ipInfoResponse .getLatitude();
                String ipLongitude = ipInfoResponse .getLongitude();
                User user = new User();
                user.setLongitude(Double.parseDouble(ipLongitude));
                user.setLatitude(Double.parseDouble(ipLatitude));
                session.setAttribute("loggedInUser", user);
                Map<String, String> locationDataIp = new HashMap<>();
                locationDataIp.put("latitude", ipLatitude);
                locationDataIp.put("longitude", ipLongitude);
                return ResponseEntity.ok(locationDataIp);
            } catch (RateLimitedException ex) {
                return ResponseEntity.status(429).body("Rate limited");
            }
        }
    }

    private void logSessionAttributes(HttpSession session) {
        logger.info("Session Attributes (ID: {}):", session.getId());
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            Object value = session.getAttribute(name);
            logger.info("  {}: {}", name, value);
        }
    }

}
