Mock hotel app for Dassault Systemes job application.

%%% Task and Purpose %%%

To create a mock hotel booking app using MVC architecture. 

Java 11
Spring Boot 2.7.6
Jpa
Thymeleaf
MySQL

Instructions:

Download and install Wampserver /// example link - https://sourceforge.net/projects/wampserver/

1. Run Wampserver;
2. Go to http://localhost/phpmyadmin/. Log in with username "root" and no password;
3. Create a new Database called "hotel-webapp", collation - utf8_general_ci;
4. If you do not have IntelliJ, you can run cmd 'mvn spring-boot:run' (before changing your local directory to the folder holding the downloaded app from Github);
5. Now you can access 'http://localhost:808/home' in your browser;
6. The code is set to generate the required 5 rooms automatically, to book, you only need to type in your first and last names;
7. You can navigate the homepage: book a room, see the room occupation status, check out, lookup the visit history;

Still quite a few things to learn, but happy overall.