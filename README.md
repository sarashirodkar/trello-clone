# Trello Clone Project

## Introduction

Incorporated the Model-View-Controller (MVC) design pattern to optimize Trello workspace operations for employees.
- Developed controllers and services to handle requests using Spring Boot, Java, and MySQL.
- Created REST APIs to facilitate efficient client-server communication and tested them using the Postman automation tool.
- Ensured Quality Assurance through Unit Testing using Mockito and JUnit.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Technologies Used

- **Spring Boot**: For backend API development
- **MySQL**: Database for storing task information
- **Hibernate**: Object-relational mapping tool
- **Maven**: Dependency management and build tool
- **MySQL**: Datbase


## Features

- Create and manage tasks
- Organize tasks in boards and lists
- View task history


## Usage

Once the application is running, you can access the endpoints using tools like Postman or directly through a frontend client. Here are some basic endpoints:

- `POST /demo/addtask`: Add a new task
- `PUT /demo/modifytask/{id}`: Modify an existing task
- `DELETE /demo/deletetask/{id}`: Delete a task
- `GET /demo/showalltask`: Retrieve all tasks
- `GET /demo/showtaskhistory/{id}`: Retrieve task history by ID



