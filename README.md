**Project Overview**

| Framework         | Language | Build Tool | Database | API Docs                       |
| ----------------- | -------- | ---------- | -------- | ------------------------------ |
| Spring Boot 3.4.3 | Java 17  | Maven      | MySQL    | SpringDoc OpenAPI (Swagger UI) |


This is a Spring Boot REST API for a simple employee management system. It provides CRUD endpoints to:

- Create new employees

- List all employees

- Fetch a single employee by ID

- Update employee details

- Delete an employee

Employees are stored in a MySQL database and mapped via JPA/Hibernate. The code follows a classic layered structure:

- EmployeeController – Handles HTTP requests and responses

- EmployeeService – Contains business logic

- EmployeeRepository – Talks to the database via Spring Data JPA

- Employee – Maps to the employee table


---

**The Problem This Project Addresses**

Modern Spring Boot makes it dangerously easy to scaffold a working app without understanding what's happening underneath. 
Developers often:

1. Add **spring-boot-starter-data-jpa** without knowing how **EntityManager** or **JPQL** work
2. Use **@RestController** without understanding **DispatcherServlet** and request lifecycle
3. Rely on Spring Data's auto-generated queries without grasping **SQL** or **repository patterns**
4. Inject beans with **@Autowired** without understanding **IoC containers** or **dependency injection**

This project is structured so you can trace every layer manually and understand why each dependency exists.

---

**Project Architecture**


- cruddemo/
  - src/
    - main/
      - java/
        - com/crudproject/springboot/cruddemo/
          - controller/   # Handles HTTP requests & responses
          - service/      # Contains business logic
          - repository/   # Talks to the database (JPA)
          - entity/       # Maps Java objects to DB tables
      - resources/
        - application.yml  # App configuration (DB, server, etc.)
  - pom.xml              # Dependency & build management

---

**How the Layers Connect**

       Client Request
              │
              ▼
    ┌───────────────────┐
    │    Controller     │  Receives HTTP requests, delegates to service
    └───────────────────┘
              │
              ▼
    ┌───────────────────┐
    │      Service      │  Applies business rules, calls repository
    └───────────────────┘
              │
              ▼
    ┌───────────────────┐
    │    Repository     │  Translates to SQL, talks to database
    └───────────────────┘
              │
              ▼
    ┌───────────────────┐
    │     Database      │  Stores and retrieves data (MySQL)
    └───────────────────┘

---

<details>
  <summary>Click to view mySQL sample for the `employee` table</summary>

    CREATE DATABASE IF NOT EXISTS `employee_directory`;
    USE `employee_directory`;

    DROP TABLE IF EXISTS `employee`;

    CREATE TABLE `employee` (
      `id` int NOT NULL AUTO_INCREMENT,
      `first_name` varchar(45) DEFAULT NULL,
      `last_name` varchar(45) DEFAULT NULL,
      `email` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

    INSERT INTO `employee` VALUES 
        (1,'Alice','Johnson','alice.johnson@example.com'),
        (2,'Bob','Martinez','bob.martinez@example.com'),
        (3,'Chloe','Nguyen','chloe.nguyen@example.com'),
        (4,'David','Kim','david.kim@example.com'),
        (5,'Eva','Rossi','eva.rossi@example.com');

</details>


