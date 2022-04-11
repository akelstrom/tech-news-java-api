# Just Tech News 

## Description
Just Tech News is a full-stack web application for developers to use as a tech only news blog. Users are able to sign up for an account. When the users login status is active, then they have the ability to create posts, edit posts, comment on posts, delete posts and read posts from others as they appear on the dashboard.   

### Purpose
I refactored an existing web application to use Java, Spring and Thymeleaf. The purpose was for me to learn how to create an RESTFUL API using Java and Spring, and then making that into a full-stack app by rendering the data on the front-end using thymeleaf. This application was developed using the MVC architectural paradigm.  

![Gif](https://github.com/akelstrom/tech-news-java-api/blob/master/src/main/resources/Homepage%20-%20Just%20Tech%20News.gif)
Visit Just-tech-news: [https://just-tech-news-java.herokuapp.com/]

## Table of Contents
1. Description/purpose
2. Tools and Frameworks
3. Installation
4. Usage
5. Testing/Endpoints
5. Author

## Tools and Frameworks
### Languages
* Java 
* HTML
* CSS
* JavaScript
* MySQL

### Frameworks
**Back-End**
* Spring
    *   Maven Repository (Dependency respository)
    *   Spring Data JPA (Object Relational Mapping)
    *   MySQL Diver (Database connection)
    *   Spring Session (User Session Management)
    *   Spring Session JDBC (Database and config support)    
    *   Spring Security (Authorization and Authentication)
    
**Front-End**
* Thymeleaf (Java template engine)
* Bootstrap (CSS Framework)

**Tools**
* Insomnia Core (API testing)
* IntelliJ (code editor)
* Heroku (Deployment)

### Installation
To install this application, first fork the repository in github, and then clone it locally on your machine. 
Install the following to run this application locally:
* mySQL
* Java JDK (16 or under)

### Usage
Java >= 16
In order to run this application locally, first make sure that you have JDK and mySQL installed locally (see installation). 
This project is running on Java 16, so make sure that the version you are using is no later than 16. Edit configurations to point to your local JDK, and then hit "run". After the application runs, open up the browser to this URL: http://localhost:8082/

### Testing/Endpoints
To test these endpoints using Insomnia core, navigate to the src --> resources --> test-data.json.
Navigate to Insomnia, and select "import from file". Select the json file from the project, and import it. You may need to make small changes to test data for a correct testing flow. 

### Author
Made with &hearts; by Alexandra Kelstrom
If you have questions, feel free to reach out by email at akelstrom@gmail.com.



