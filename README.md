# Smart Data Mediator (Java)

## Overview

Smart Data Mediator is a Java Spring Boot–based data analytics application that enables users to query a database using natural language. The system interprets user input, converts it into SQL queries, retrieves data from a MySQL database, and presents results in both tabular and chart-based visualizations. The application includes authentication, query history management, and an admin dashboard for monitoring analytics.

## Features

* Natural language–style query processing
* Automatic SQL query generation
* MySQL database integration
* Interactive chart visualization (Bar, Line, Pie)
* Admin-only authentication system
* Query history tracking
* Dashboard analytics
* REST API–based backend architecture
* Responsive web interface
* Chart type selection dropdown

## Technology Stack

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate

### Frontend

* HTML
* CSS
* JavaScript
* Chart.js

### Database

* MySQL

### Tools

* Maven
* Git
* GitHub

## Project Structure

```
smart-data-mediator/
│
├── src/main/java/com/smartmediator
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   └── config
│
├── src/main/resources
│   ├── templates
│   ├── static
│   └── application.properties
│
├── pom.xml
└── README.md
```

## Database Schema

The application uses the following tables:

* employee
* department
* projects
* clients
* query_history

## How It Works

1. User enters a natural language query in the dashboard
2. System analyzes the query using keyword-based parsing
3. Application generates a corresponding SQL query
4. Spring Boot executes the query using JPA/Hibernate
5. Results are returned as JSON
6. Frontend displays data in table format
7. Chart.js renders selected chart visualization
8. Query is stored in query history table

## Installation and Setup

### Prerequisites

* Java 17 or higher
* MySQL Server
* Maven
* Git

### Step 1: Clone Repository

```
git clone https://github.com/your-username/smart-data-mediator-java.git
```

### Step 2: Configure Database

Update application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/hr_system
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Step 3: Run Application

```
mvn spring-boot:run
```

### Step 4: Open Browser

```
http://localhost:9090
```

## Future Enhancements

* Advanced NLP query understanding
* Export reports (PDF/Excel)
* Multiple dataset upload
* User role management
* Advanced analytics dashboard
* Real-time chart updates
* Query suggestions

## Author

Ritu

This project is for academic and educational purposes.
