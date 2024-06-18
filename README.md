# MakerSharks-Inc--Assignment

User Registration API
This project implements a RESTful API for user registration and fetching user details using Spring Boot.

Requirements
Java 8 or higher
Maven

# Setup Instructions

Clone the repository:
git clone https://github.com/your_username/user-registration-api.git
cd user-registration-api

Build the project:
mvn clean package

Run the application:
java -jar target/user-registration-api.jar
The application will start on http://localhost:8080.

# API Endpoints
Register User:

URL: POST /api/user/register
Request Body: JSON object containing user details (username, email, password)
Response: Success message or error message if registration fails
Fetch User Details:

URL: GET /api/user/fetch?username={username}
Response: User details in JSON format if user exists, or 404 Not Found if user does not exist
