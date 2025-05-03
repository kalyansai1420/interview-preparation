document.addEventListener('DOMContentLoaded', () => {
    const getLocationBtn = document.getElementById('getLocationBtn');
    const locationInfoDiv = document.getElementById('locationInfo');
    const orderRequestJsonTextarea = document.getElementById('orderRequestJson');
    const sendOrderBtn = document.getElementById('sendOrderBtn');
    const orderResponseDiv = document.getElementById('orderResponse');
  
    if (getLocationBtn) {
      getLocationBtn.addEventListener('click', getLocation);
    } else {
      console.error("Get Location button not found!");
    }
    if (sendOrderBtn) {
        sendOrderBtn.addEventListener('click', sendOrderRequest);
    } else {
        console.error("Send Order button not found!");
    }
  
    function getLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          position => {
            const latitude = position.coords.latitude;
            const longitude = position.coords.longitude;
            console.log("Latitude:", latitude);
            console.log("Longitude:", longitude);
            sendLocationToLogin(latitude, longitude);
            if (locationInfoDiv) {
              locationInfoDiv.innerText = `Latitude: ${latitude}, Longitude: ${longitude}`;
            }
          },
          showError
        );
      } else {
        if (locationInfoDiv) {
          locationInfoDiv.innerText = "Geolocation is not supported by this browser.";
        } else {
          console.error("Location info div not found!");
        }
      }
    }
  
    function sendLocationToLogin(latitude, longitude) {
      const loginData = {};
      if (latitude !== null && longitude !== null) {
        loginData.latitude = latitude;
        loginData.longitude = longitude;
      }
  
      fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(loginData),
        credentials: 'include'
      })
      .then(response => response.json())
      .then(data => {
        console.log("Login response:", data);
        if (locationInfoDiv) {
          locationInfoDiv.innerText = `Login successful. Response: ${JSON.stringify(data)}`;
        }
        // Handle successful login, e.g., redirect
      })
      .catch(error => {
        console.error("Error during login:", error);
        if (locationInfoDiv) {
          locationInfoDiv.innerText = `Error during login: ${error.message}`;
        }
      });
    }

    function sendOrderRequest() {
        const orderJson = orderRequestJsonTextarea.value;
        console.log("Order",orderJson);

        try {
            const orderData = JSON.parse(orderJson);
            console.log(orderData)

            fetch('http://localhost:8080/processOrder', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(orderData),
                credentials: 'include'
            })
            .then(response => response.json())
            .then(data => {
                console.log("Process Order Response:", data);
                if (orderResponseDiv) {
                  let html = "<h3>Order Fulfillment:</h3><ul>";
                  for (const [itemId, shipments] of Object.entries(data)) {
                      html += `<li><strong>Item: ${itemId}</strong><ul>`;
                      shipments.forEach(entry => {
                          if (entry.message) {
                              html += `<li style="color:red;">${entry.message}</li>`;
                          } else {
                              html += `<li>Warehouse ${entry.warehouseId} → ${entry.quantity} units</li>`;
                          }
                      });
                      html += "</ul></li>";
                  }
                  html += "</ul>";
                  orderResponseDiv.innerHTML = html;
                }
            })
            .catch(error => {
                console.error("Error sending order request:", error);
                if (orderResponseDiv) {
                    orderResponseDiv.innerText = `Error sending order request: ${error.message}`;
                }
            });

        } catch (error) {
            console.error("Invalid JSON in order request:", error);
            if (orderResponseDiv) {
                orderResponseDiv.innerText = "Invalid JSON in order request.";
            }
        }
    }

  
    function showError(error) {
      let errorMessage = "";
      switch (error.code) {
        case error.PERMISSION_DENIED:
          errorMessage = "User denied the request for Geolocation.";
          break;
        case error.POSITION_UNAVAILABLE:
          errorMessage = "Location information is unavailable.";
          break;
        case error.TIMEOUT:
          errorMessage = "The request to get user location timed out.";
          break;
        case error.UNKNOWN_ERROR:
          errorMessage = "An unknown error occurred.";
          break;
      }
      if (locationInfoDiv) {
        locationInfoDiv.innerText = `Error: ${errorMessage}`;
      } else {
        console.error("Location info div not found!");
      }
    }
  });