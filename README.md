<h1 align="center">
  <br>
  👨‍💼 Employee Management System
  <br>
</h1>

<p align="center">
  <strong>A production-ready RESTful CRUD API built with Spring Boot, JPA & MySQL</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.0.3-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-8.x-4479A1?style=for-the-badge&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" />
  <img src="https://img.shields.io/badge/Lombok-Enabled-BC4521?style=for-the-badge" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/REST_API-✔-brightgreen?style=flat-square" />
  <img src="https://img.shields.io/badge/Bean_Validation-✔-brightgreen?style=flat-square" />
  <img src="https://img.shields.io/badge/Global_Exception_Handler-✔-brightgreen?style=flat-square" />
  <img src="https://img.shields.io/badge/DTO_Pattern-✔-brightgreen?style=flat-square" />
</p>

---

## 📌 Table of Contents

- [Overview](#-overview)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [API Endpoints](#-api-endpoints)
- [Data Model](#-data-model)
- [Getting Started](#-getting-started)
- [Configuration](#-configuration)
- [Sample Requests](#-sample-requests)
- [Error Handling](#-error-handling)

---

## 🔍 Overview

A clean, layered Spring Boot REST API that manages employee records. Built with standard enterprise patterns — Controller → Service → Repository — with validation, DTO mapping, and centralized exception handling baked in.

> **Stack Intent:** Backend REST service. No frontend. Designed to be consumed by any HTTP client (Postman, curl, frontend app).

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.0.3 |
| Web | Spring MVC (REST) |
| Persistence | Spring Data JPA + Hibernate |
| Database | MySQL 8.x |
| Validation | Jakarta Bean Validation |
| Boilerplate Reduction | Lombok |
| Build Tool | Maven |
| Dev Productivity | Spring DevTools |

---

## 📁 Project Structure

```
employeemanagement/
├── src/
│   └── main/
│       ├── java/com/example/employeemanagement/
│       │   ├── EmployeemanagementApplication.java   # Entry point
│       │   ├── controller/
│       │   │   └── EmployeeController.java          # REST endpoints
│       │   ├── service/
│       │   │   ├── EmployeeService.java             # Service interface
│       │   │   └── EmployeeServiceImpl.java         # Business logic
│       │   ├── repository/
│       │   │   └── EmployeeRepository.java          # JPA repository
│       │   ├── entity/
│       │   │   └── Employee.java                    # JPA entity
│       │   ├── dto/
│       │   │   └── EmployeeDTO.java                 # Data Transfer Object
│       │   └── exception/
│       │       ├── ResourceNotFoundException.java   # Custom 404 exception
│       │       └── GlobalExceptionHandler.java      # Centralized error handling
│       └── resources/
│           └── application.properties               # App configuration
├── pom.xml
└── mvnw
```

---

## 🔗 API Endpoints

**Base URL:** `http://localhost:8080/api/employees`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| `POST` | `/api/employees` | Create a new employee | `201 Created` |
| `GET` | `/api/employees` | Fetch all employees | `200 OK` |
| `GET` | `/api/employees/{id}` | Fetch employee by ID | `200 OK` |
| `PUT` | `/api/employees/{id}` | Update employee by ID | `200 OK` |
| `DELETE` | `/api/employees/{id}` | Delete employee by ID | `200 OK` |

---

## 📦 Data Model

### `Employee` Entity → `employees` table

| Field | Type | Constraints |
|-------|------|-------------|
| `id` | `Long` | Auto-generated primary key |
| `name` | `String` | `@NotBlank` — required |
| `email` | `String` | `@Email` — valid format, unique |
| `department` | `String` | `@NotBlank` — required |
| `salary` | `Double` | `@Min(0)` — cannot be negative |

---

## 🚀 Getting Started

### Prerequisites

- ✅ Java 17+
- ✅ Maven 3.6+
- ✅ MySQL 8.x running locally

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/employeemanagement.git
cd employeemanagement
```

### 2. Configure the Database

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/EmployeeDB?createDatabaseIfNotExist=true
spring.datasource.username=your_username
spring.datasource.password=your_password
```

> The database `EmployeeDB` is auto-created on first run via `createDatabaseIfNotExist=true`. The `employees` table is auto-managed by Hibernate (`ddl-auto=update`).

### 3. Build & Run

```bash
# Using Maven Wrapper
./mvnw spring-boot:run

# Or build JAR and run
./mvnw clean package
java -jar target/employeemanagement-0.0.1-SNAPSHOT.jar
```

The server starts at **`http://localhost:8080`**.

---

## ⚙️ Configuration

```properties
# application.properties

spring.application.name=employeemanagement
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/EmployeeDB?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 Sample Requests

### ➕ Create Employee

```http
POST /api/employees
Content-Type: application/json

{
  "name": "Darshan Siddarth",
  "email": "darshan@example.com",
  "department": "Engineering",
  "salary": 75000.00
}
```

**Response:** `201 Created`
```json
{
  "id": 1,
  "name": "Darshan Siddarth",
  "email": "darshan@example.com",
  "department": "Engineering",
  "salary": 75000.00
}
```

---

### 📋 Get All Employees

```http
GET /api/employees
```

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "name": "Darshan Siddarth",
    "email": "darshan@example.com",
    "department": "Engineering",
    "salary": 75000.00
  }
]
```

---

### ✏️ Update Employee

```http
PUT /api/employees/1
Content-Type: application/json

{
  "name": "Darshan Siddarth",
  "email": "darshan@example.com",
  "department": "Backend",
  "salary": 90000.00
}
```

---

### 🗑️ Delete Employee

```http
DELETE /api/employees/1
```

**Response:** `200 OK`
```
Employee deleted successfully
```

---

## ⚠️ Error Handling

All errors are handled globally via `GlobalExceptionHandler`.

| Scenario | HTTP Status | Response |
|----------|-------------|----------|
| Employee not found | `404 Not Found` | `{ "message": "..." }` |
| Validation failure | `400 Bad Request` | Field-level error messages |
| Duplicate email | `500` / DB constraint | Error detail |

**Example Validation Error:**
```json
{
  "name": "Name is required",
  "email": "Invalid email format"
}
```

---

## 👤 Author

**K C Darshan**
📧 darshansiddarth05@gmail.com
🎓 B.E. Computer Science — VTU, Bengaluru

---

<p align="center">
  Built with ☕ Java & 🌱 Spring Boot
</p>
