# WhealOnMeal Web Application 
This application is forked from the Spring Petclinic application with a choice of JPA and HSQLDB. The link of this repo is [spring-projects/spring-mealOnWheel](https://github.com/spring-projects/spring-mealOnWheel). We used this repo to start our project with Spring, hibernate, jquery, maven, hsqldb, Boostrape and JQuery setting up.

## Running our application locally
```
	git clone https://github.com/SENG330-17/project-team_1-2.git
	cd Project/spring-framework-mealOnWheel-master-5/
	./mvnw tomcat7:run-war
```

You can then access application here: http://localhost:9966/mealOnWheel/


## Database configuration

Since we use HSQLDB as our in-memory database, we don't need a extra database server to manage our data. So there's nothing need to set up in database.


## Working with Petclinic in Eclipse/STS

### prerequisites
need to have following things installed in your computer:
* Maven 
* git command line tool 
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line
```
git clone https://github.com/spring-mealOnWheel/spring-framework-mealOnWheel.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```







