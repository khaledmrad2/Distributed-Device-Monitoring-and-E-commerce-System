# `Distributed Device Monitoring and E-commerce System`

## Project Overview
This project is a distributed system developed using Java Spring Boot and Maven. The system comprises two main components:

Distributed Device Monitoring System: This system enables a manager to monitor company devices. Using RMI (Remote Method Invocation), the manager can:

Capture images using the computer's camera and view them remotely.
Take screenshots of the computer's screen and display them on the manager's device.
Obtain the device's address and communicate with it via sockets.
Distributed E-commerce System: The project also implements a distributed e-commerce application catering to multiple market sectors (B2B, B2C, C2C, and C2B). It consists of several microservices and integrates with dynamic service discovery, gateway management, and load balancing.


## The System features
 ## 1.  Distributed Device Monitoring System
RMI-based Image and Screenshot Capture: The system allows the manager to remotely capture images from employees’ device cameras and take screenshots, even for remote employees.
Dynamic IP Handling: As employees work remotely, the system periodically exchanges remote references to handle dynamic IP changes.
Socket-based Communication: The manager can communicate directly with a device by retrieving its address and sending messages via sockets.
## 2. Distributed E-commerce System
B2B, B2C, C2C, C2B Support: The system covers the four primary sectors of e-commerce, allowing businesses and consumers to interact in various transactional models.
Service Discovery: Leveraging a discovery service, system services are dynamically addressed for flexible communication.
Gateway Management: A gateway manages service calls to route them efficiently to the respective services.
Failure Management and Load Balancing:
Hystrix: Ensures resilience by handling service failures and latency issues.
Ribbon: Implements load balancing across services to optimize performance and resource usage.

 
# Services
The system is built with the following services:

Transaction Service: Handles the business transactions and payments.
User Service: Manages user authentication, registration, and user data.
Goods Service: Handles product listings, inventory, and goods management.
API Gateway: Manages service routing and interaction with the discovery service.


# Technologies Used
- Java Spring Boot: For building the microservices.
- RMI (Remote Method Invocation): For distributed device monitoring.
- Socket Communication: For real-time messaging between the manager and devices.
- Service Discovery & API Gateway: For dynamic addressing and gateway routing.
- Hystrix: For failure management and latency handling.
- Ribbon: For load balancing across internal services.




## Installation

```
Clone the repository.
Build the project using Maven:
mvn clean install
Run xammp Local Server
Run each service individually:
mvn spring-boot:run
```



## 🛠 Skills
- Java Spring Boot: Developed microservices using Spring Boot, including transaction, user, and goods services.
- Distributed Systems: Built a device monitoring system with RMI and socket-based communication for remote management.
- Service Discovery & API Gateway: Implemented dynamic service addressing with discovery service and API Gateway.
- E-commerce System: Developed a distributed system for B2B, B2C, C2C, and C2B transactions.
- Fault Tolerance: Applied Hystrix for managing failures and latency in service communication.
- Load Balancing: Implemented Ribbon for load balancing across services.
- Socket Programming: Enabled real-time device communication with a socket-based solution.
- Maven: Managed project dependencies and builds using Maven.
- RESTful Web Services: Developed REST APIs for inter-service communication.


## 🔗 Links

- [More Info](https://mega.nz/folder/P2YhQAqL#XtaQy83oBbPyXdqUsDO2VA)


## Author🚀

- [Khaled Morad](https://www.linkedin.com/in/khaledmorad)


## 🔗 About Me
If you have any questions or suggestions, feel free to reach out to us at :


[![GitHub](https://img.shields.io/badge/GitHub-333?style=for-the-badge&logo=github&logoColor=white)](https://github.com/khaledmrad2)

[![GitLab](https://img.shields.io/badge/-Gitlab-orange?logo=gitlab&logoColor=white&style=for-the-badge)](https://gitlab.com/khaledmorad)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/khaledmorad)

[![gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:khaled.morad.br@gmail.com)

#### Good Luck, and Thanks For Your Time