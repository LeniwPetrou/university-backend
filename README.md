# University Project - Backend

This project is the backend part of a web app related to a university. You can find frontend [here](https://github.com/LeniwPetrou/university-frontend)

## API Structure

More specifically, the structure that has been followed is:

### Controllers
The controller classes are responsible for processing incoming REST API requests, preparing a model, and returning the view to be rendered as a response. @RequestMapping annotation on the class defines a base URL for all the REST APIs created in this controller. **@RestController** on the class is a **combination** of 
**@Controller** which tells Spring Boot that **this class is a controller** and **@ResponseBody** which indicates that **the return value of the methods inside the controller will be returned as the response body for the REST API**. Also, **service** is **injected** as a dependency using **@Autowired** annotation (dependency injection).

### Services
The service component contains **business logic**. Each of these methods will call JpaRepository methods extended by Repository.

### Repositories
Repositories generated in order to be executed the **CRUD operations**. CRUD is an acronym that stands for the four basic operations of the database - *Create, Read, Update, Delete*. **Every single repository extends JpaRepository**. There are **two parameters passed to the JpaRepository** - *first parameter* is the *model class* that will be managed by this repository, *second* is the data type of the *primary key*.

The JpaRepository interface provided by Spring Data JPA makes it possible for the repository class to *retrieve, update, delete records* in every table.

This interface also defines methods such as save(), findAll() , delete(), to operate on the database. The implementation of these methods is provided by the default implementation class called *SimpleJpaRepository*.

### DTOs
DTO, which stands for **Data Transfer Object**, is a **design pattern** conceived to reduce the number of remote calls that are expensive.

### Models
It is a collection of classes, that you will need to use later instruction. **Hibernate** (Java mapping tool) refers to these classes as **Entities**. Fetch each Entity from Hibernate, create a table to map its fields, and it will then act as a managed entity for your Database. 

**Source:** https://www.twilio.com/blog/create-rest-apis-java-spring-boot


