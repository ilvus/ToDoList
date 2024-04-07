
# Java To-Do List Application


This is a Java-based To-Do List application built using Spring Boot. It allows users to manage their tasks efficiently.

**Setup**

1. Utilize Spring Initializr to create a new project with the required dependencies.

2. Develop entities representing the data model of the application. Ensure appropriate relationships between entities.

3. Create a bean/class for bootstrap data for the development environment. You can implement data from a CSV file generated using generators.

4. Configure the application to use H2 as the default database profile and PostgreSQL as an alternative profile.

5. Implement repositories for data access and write unit tests for them.

6. Create Data Transfer Objects (DTOs) and implement mappers for converting between entities and DTOs. Write unit tests for the mappers.

7. Implement services to handle business logic.

8. Develop REST controllers to expose CRUD operations (GET, POST, PUT, PATCH, DELETE) for the entities. Write unit tests for controllers using MockMVC and Mockito. Make commits for each operation in Git.

9. Write integration tests to ensure seamless interaction between different layers of the application.

10. Handle exceptions gracefully using Spring MVC.

11. Validate data using Hibernate data validator. Write tests for exception handlers and data validations.

12. Setup OpenAPI and SwaggerUI for API documentation.

**Running the Application**

Make sure you have Java and Maven installed on your system.

Clone the repository: git clone https://github.com/ilvus/ToDoList.git

Navigate to the project directory: cd ToDoList

Build the project: mvn clean install

Run the application: mvn spring-boot:run


**SRS**: https://docs.google.com/document/d/1X0du-1tlHpapm6dSgfGmp98tEZNRVoZcInvIIkgUqsA/edit?usp=sharing

