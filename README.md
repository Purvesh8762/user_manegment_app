Application
📌 Project Overview

This is a User Management Application developed using Spring Boot for the backend and React / Expo for the frontend.
The project demonstrates how to build RESTful APIs, connect them with a frontend application, and perform basic CRUD operations on users.

This project was created mainly for learning purposes, interviews, and practical understanding of full-stack development.

🚀 Features

Create new users

View all users

Update user details

Delete users

REST API based communication

JSON request & response handling

🛠️ Technologies Used
Backend

Java

Spring Boot

Spring Data JPA

Hibernate

Maven

Frontend

React / Expo (Mobile App)

Database

MySQL

Tools

Postman (API testing)

VS Code / IntelliJ IDEA

🏗️ Project Architecture

The project follows a layered architecture:

Controller Layer – Handles HTTP requests

Service Layer – Contains business logic

Repository Layer – Handles database operations

Entity Layer – Maps Java classes to database tables

📂 Backend Modules

UserController – API endpoints

UserService – Business logic

UserRepository – JPA repository

User – Entity class

🧑‍💻 Database Structure

Users Table Fields:

id

name

email

role

▶️ How to Run the Project
Backend (Spring Boot)

Clone the repository

Open the backend project in IntelliJ / Eclipse

Configure MySQL database in application.properties

Run the project as Spring Boot Application

Server will start on port 8080

Frontend (React / Expo)

Navigate to frontend folder

Run npm install

Run npm start or expo start

Update API base URL with your system IP address

⚠️ Note:
When testing on a mobile device, use your local IP address instead of localhost.

🧪 API Testing

APIs can be tested using Postman.

Example endpoints:

GET /users

POST /users

PUT /users/{id}

DELETE /users/{id}

❗ Challenges Faced

Backend connection issues on mobile

Maven dependency conflicts

Data not displaying due to incorrect API mapping

These issues were resolved through debugging and configuration fixes.

📚 What I Learned

Spring Boot project structure

REST API development

Frontend and backend integration

Database connectivity using JPA

Real-world debugging experience

🔮 Future Enhancements

JWT authentication

Role-based access control

Input validation

Global exception handling

Cloud deployment

👤 Author

Purvesh Sawalakhe
Java & Spring Boot Developer (Fresher)# user_manegment_app
