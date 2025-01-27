# User Management Application

___

## Description

This system is defined to give a starter web MVC application for users' management, this system allows to execute CRUD
operations for roles and users, this system implements a basic MVC implementation for a web project using Spring
Framework
and storing data into a MySQL DataBase.
___

## Features

- Roles management CRUD
- Users management CRUD
- Spring Framework as core structure
- Spring Boot base configuration
- Liquibase implementation for DataBase version control.

___

## Technologies

- Java JDK 17
- Spring Boot 3.4
- Spring Framework 6
- Liquibase
- Lombok
- Spring Web MVC with JSP pages

___

## Structure

The project uses the next main structure of directories:

```
task-mvc
  |-> .infrastructure
         |-> config
               |-> mysql
                     |- my.cnf
         |-> docker-compose.yml     
  |-> src
        |-> java
              |-> co.edu.uniminuto.mvc
                    |-> config
                    |-> constants
                    |-> controller
                    |-> data
                          |-> model
                          |-> repository
                    |-> service
                    |-> InitApp.java
        |-> resources
        |-> webapp
              |-> WEB-INF
                    |-> jsp
```
___

## Technical Specifications

- Docker Desktop
- Java JDK 17 (minimus)
- Maven 3.9.0 (minimus)
___

## Project Execution

To run the project, you should run next steps after clone this project and go to project base directory.

1. Start docker service container for MySQL database, run the next command, required Docker.
   ```
   docker-compose -f .\.infrastructure\docker-compose.yml up -d 
   ``` 
2. Compile the project using next Maven command:
   ```
   cd task-mvc
   mvn clean package
   ```
3. The command given above compiles and create a War file with all required libraries to execute the application with 
Java command, so you should go to target directory into base project directory, and to run the commando to execute the app.
   ```
   cd target
   java -jar task-mvc-1.0.0-SNAPSHOT.war --spring.profiles.active=dev
   ```
   If you want to run the application from your preferred IDE, you have to import the maven project, and create a new
execution action using the main application class to start it.
   ```
   co.edu.uniminuto.mvc.InitApp
   ```
4. To Finish executions, you should execute keys combination `Ctrl + C` and then, after application finished, you could 
stop docker container with next command.
   ```
   docker-compose -f .\.infrastructure\docker-compose.yml down
   ```
___

## Data Base Configuration

This project uses Liquibase for database structure definition, and the docker-compose command creates the service and 
database, so all steps are autoconfigured when the application starts.
___

## Notes

This project was based on JHipster structure and some classes were replicated to simplificate and to avoid to import not
required dependencies.
