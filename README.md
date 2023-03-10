#  Excel Parser 
___
## :bulb: ***Project description***

    Web-application that alows parse xlsx file and save data to database.

## :scroll: ***Project structure***

    The project has an N-Tier Architecture.

+ *Dao*
+ *Service*
+ *Controller*

## :exclamation: ***Features***

+ *Parse xlsx file*
+ *Save data to database*
+ *Create txt file history of changes database*
+ *Show history of changes*
+ *Registration and authorization based on JWT tokens*
+ *Generate database pdf file*
+ *Search data by id, name, lastname*

## :books: ***Technologies***

+ *MySql*
+ *Maven*
+ *Stream API*
+ *Hibernate*
+ *Spring WEB*
+ *Spring Boot*
+ *Spring Boot Jpa*
+ *Spring Security*
+ *Lombok*
+ *REST*
+ *SOLID principles*
+ *Swagger*
+ *iTextPdf*
+ *jjwt*

## :desktop_computer: ***Quickstart***

1. Fork this repository
2. Copy link of project
3. Create new project from Version Control
4. Set the necessary parameters in resources/application.properties
```java
    spring.datasource.driverClassName=YOUR_DRIVER
    spring.datasource.url=YOUR_DATABASE_URL
    spring.datasource.username=YOUR_LOGIN
    spring.datasource.password=YOUR_PASSWORD
```

5. Run script in your database from file init_db.sql
6. Run project
7. Test all controllers by swagger. Follow next link :

http://localhost:8080/swagger-ui/#/
