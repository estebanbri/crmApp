# crmApp

Customer Relationship Management. Frameworks: Spring, Spring MVC, Hibernate, Flyway, Spring AOP, Spring Security, Spring REST

> http://localhost:8080/crmWebApp/swagger-ui.html


![alt text](https://github.com/estebanbri/crmApp/blob/master/src/main/resources/img/swagger.png)

## TABLA CLIENTE

>CREATE TABLE CLIENTE(
ID_CLIENTE INT PRIMARY KEY AUTO_INCREMENT,
PRIMER_NOMBRE VARCHAR,
OPTIMISTIC_LOCK_VERSION DOUBLE);

## RUN THE APPLICATION
>$ mvn jetty:run
