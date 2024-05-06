## Project Contents
### Book Microservice
- Swagger
  : http://localhost:8083/docs/swagger-ui/index.html#/

### Getting Started
#### Installation
- Instructions for downloading and running the project in a local environment.
1. Clone this repository.    
   `git clone https://github.com/dobecom/Java-Spring-JPA.git`
2. Open the project and Reload All Gradle Project
3. Create Docker Containers for MySQL DB and Redis.
   </br> `cd docker/`
   </br> `docker compose up -d`
4. Run Java Application (BookApplication.java)
    - Ref. Creating DB table and data automatically is optional in application.yml by modifying spring.jpa.hibernate.ddl-auto and spring.sql.init.mode
