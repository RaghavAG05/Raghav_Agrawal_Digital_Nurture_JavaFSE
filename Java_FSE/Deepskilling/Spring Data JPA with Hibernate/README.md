# Spring Data JPA with Hibernate

This folder contains the **Spring Data JPA with Spring Boot and Hibernate** hands-on exercises completed as part of the **Cognizant Digital Nurture – Java Full Stack Engineer (Java FSE)** training program.

## Exercises Completed

### 1. Spring Data JPA – Quick Example

- Configured a Spring Boot application with Spring Data JPA.
- Connected the application to a MySQL database.
- Implemented the `Country` entity.
- Created a `JpaRepository` for database operations.
- Retrieved all countries from the database.

---

### 2. Difference Between JPA, Hibernate and Spring Data JPA

- Studied the Java Persistence API (JPA).
- Understood Hibernate as the implementation of JPA.
- Learned how Spring Data JPA reduces boilerplate code.
- Compared JPA, Hibernate and Spring Data JPA.

---

### 3. Implement Services for Managing Country

- Implemented the service layer for Country management.
- Used `JpaRepository` for CRUD operations.
- Applied the Service-Repository architecture.

---

### 4. Find Country Based on Country Code

- Retrieved country details using the country code.
- Used Spring Data JPA repository methods.
- Implemented service layer logic.

---

### 5. Add a New Country

- Inserted a new country into the database.
- Saved data using Spring Data JPA.
- Verified data persistence in MySQL.

---

### 6. Query Methods

Implemented various Spring Data JPA Query Methods including:

- Search by containing text
- Search by starting text
- Case-insensitive search
- Sorting using `OrderBy`
- Repository method name conventions

Implemented methods:

```java
findByNameContainingIgnoreCase()

findByNameContainingIgnoreCaseOrderByNameAsc()

findByNameStartingWithIgnoreCase()

findByNameStartingWithIgnoreCaseOrderByNameAsc()
```

---

## Technologies Used

- Java 25
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- IntelliJ IDEA

---

## Folder Structure

```text
Spring Data JPA with Hibernate
│
├── 1. spring-data-jpa-handson
│   ├── Spring Data JPA - Quick Example
│   ├── Difference between JPA, Hibernate and Spring Data JPA
│   ├── Exercise_2_Implement_Services_For_Managing_Country
│   ├── Exercise_3_Find_Country_Based_On_Country_Code
│   └── Exercise_4_Add_New_Country
│
├── 2. spring-data-jpa-handson
│   └── Query_Methods_Country
│
└── README.md
```

---

## Learning Outcomes

After completing these exercises, I was able to:

- Configure Spring Boot with Spring Data JPA.
- Implement Repository and Service layers.
- Perform CRUD operations using `JpaRepository`.
- Use Spring Data JPA Query Methods.
- Implement sorting and filtering using method naming conventions.
- Understand the differences between JPA, Hibernate and Spring Data JPA.

---

## Author

**Raghav Agrawal**