# spring-boot-synthea
This project combines a Spring Boot backend with a React frontend using Vite. The goal is to practice integrating frontend and backend technologies to create a functional web application.

## Features Implemented:
### Spring Boot Backend:

Created a RESTful API using Spring Boot.
Implemented a controller (TestController) to handle HTTP GET requests.
Configured a MySQL database connection to store and retrieve data.
### React + Vite Frontend:

Developed a simple React component (ApiButton.jsx) to interact with the backend.
Implemented a button that sends an HTTP GET request to the Spring Boot backend.
Displayed the response data from the backend on the frontend.
### Technologies Used:
Backend: Java, Spring Boot, Spring MVC, MySQL, Maven
Frontend: JavaScript (React), Vite
Database: MySQL
### Purpose:
This project serves as a learning exercise to:

Understand how to set up and integrate a Spring Boot backend with a React frontend.
Practice creating and consuming RESTful APIs.
Gain familiarity with deploying and testing web applications locally.
Future updates will focus on expanding functionality, enhancing user interface, and deploying the application for further testing and development.

# Database
## Connecting MySQL Database to Spring Boot Application
### Setup Steps
#### MySQL Database Setup

Create a new database schema named synthea using MySQL Workbench

#### Integrating MySQL Connector

Download mysql-connector-java-9.0.0.jar from MySQL's official site.
Create a lib directory in the project's root.
Place the JAR file into the lib directory.
Configuring Spring Boot Application

Add MySQL Connector dependency to pom.xml:

`<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>9.0.0</version>
</dependency>`

#### Configure database connection in src/main/resources/application.properties:

`spring.datasource.url=jdbc:mysql://localhost:3306/synthea
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect`

#### Implementing JDBC Connection

On your main spring boot application (SpringBootSyntheaApplication.java in this project), 
use JDBC to connect to MySQL and retrieve data from the NAMES table.
#### Running the Application

Start the Spring Boot application using IntelliJ IDEA or Maven CLI (mvn.cmd spring-boot:run).
Ensure MySQL server is running.
Upon successful execution, the application will connect to the synthea database and print names from the NAMES table.
Notes
File Location: SpringBootSyntheaApplication.java is located in src/main/java/com/example/spring_boot_synthea/.
Integration: This setup integrates Spring Boot with MySQL using JDBC for database connectivity.
Documentation: Document these steps clearly in your project's README or documentation for future reference.

Youtube Video Tutorial for datbase connection to intelliJ with Spring Boot: https://www.youtube.com/watch?v=9ntKSLLDeSs