package com.example.q1.config;

import jakarta.servlet.SessionTrackingMode;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.apache.tomcat.util.http.SameSiteCookies;

import java.util.EnumSet;

@Configuration
public class SessionConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Force session tracking by cookies only
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));

        // Configure session cookie attributes
        servletContext.getSessionCookieConfig().setHttpOnly(true);
        servletContext.getSessionCookieConfig().setSecure(false); // true if HTTPS; false for localhost
        servletContext.getSessionCookieConfig().setPath("/");
        servletContext.getSessionCookieConfig().setName("JSESSIONID");
    }

    @Bean
    public TomcatServletWebServerFactory cookieSameSiteFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addContextCustomizers(context -> {
            Rfc6265CookieProcessor cookieProcessor = new Rfc6265CookieProcessor();
            cookieProcessor.setSameSiteCookies(SameSiteCookies.LAX.getValue()); // Use LAX for localhost
            context.setCookieProcessor(cookieProcessor);
        });
        return factory;
    }
}
