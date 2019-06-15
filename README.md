# restapi
A demo to create REST API using Spring Boot

The REST API is a communication between client and server to manage data using the HTTP method (POST, GET, PUT, DELETE)

## Get Started 

### This project is built using SpringBoot. Tools that must be prepared before build the application:
```
1. Java 1.8
2. Maven
3. IDE, for example: IntelliJ
4. Lombok plugin
```

### This project is consist of:
- a simple endpoints
- a simple unit testing
- exception handler
- actuator to see the information about the app, the environment where the app running, and healthcheck
- API Swagger for documentation
- the application.properties to change the environment configuration

### Dependencies that we used:
```
- Web         : to create restfull web service
- Lombok      : to help us create a simple code, such as generate a Setter Getter and Logger
- Actuator    : for the healthcheck
- Swagger2    : for the documentation 
- Swagger UI  : The Swagger UI
```
The dependence will be added to a file called **pom.xml**
