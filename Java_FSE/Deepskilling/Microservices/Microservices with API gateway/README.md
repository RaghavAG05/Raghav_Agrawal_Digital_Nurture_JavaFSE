# Creating Microservices for Account and Loan

This project is part of the **Cognizant Digital Nurture – Java Full Stack Engineer (Java FSE)** training program.

The objective of this hands-on exercise is to create two independent Spring Boot RESTful microservices for a banking application:

- **Account Microservice**
- **Loan Microservice**

Each microservice is a standalone Spring Boot Maven project with its own configuration and runs independently.

---

# Project Structure

```text
Creating Microservices for Account and Loan
│
├── account
│   ├── src
│   ├── pom.xml
│   └── application.properties
│
├── loan
│   ├── src
│   ├── pom.xml
│   └── application.properties
│
└── README.md
```

---

# Technologies Used

- Java 25
- Spring Boot 3
- Spring Web
- Spring Boot DevTools
- Maven
- REST API

---

# Account Microservice

### Endpoint

```
GET /accounts/{number}
```

### Sample Request

```
GET http://localhost:8080/accounts/00987987973432
```

### Sample Response

```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343.0
}
```

Runs on:

```
http://localhost:8080
```

---

# Loan Microservice

### Endpoint

```
GET /loans/{number}
```

### Sample Request

```
GET http://localhost:8081/loans/H00987987972342
```

### Sample Response

```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000.0,
  "emi": 3258,
  "tenure": 18
}
```

Runs on:

```
http://localhost:8081
```

---

# Configuration

### Account Service

Default Spring Boot port:

```
8080
```

### Loan Service

Configured using:

```properties
server.port=8081
```

This allows both microservices to run simultaneously without any port conflict.

---

# Build the Projects

```bash
mvn clean package
```

---

# Run the Applications

Run the following application classes:

- `AccountApplication.java`
- `LoanApplication.java`

Both services should start successfully on their respective ports.

---

# Learning Outcomes

- Understand the Microservices Architecture.
- Create independent Spring Boot applications.
- Develop RESTful APIs using Spring Boot.
- Configure different ports for multiple services.
- Test REST APIs using Browser or Postman.
- Build standalone Maven-based microservices.

---

# Author

**Raghav Agrawal**
