-- How to run endpoint - Step by Step --

1- To run this maven project we first need an Eclipse EE workspace running with Java 11
download: https://www.eclipse.org/downloads/packages/release/2021-03/r/eclipse-ide-enterprise-java-and-web-developers

Thats the only ide that would fit this project becouse it comes with an enbedded tomcat server
to locally host the app.

2- The next step it would be to import the project into this new eclipse workspace.
Wait for all maven dependencies to start.

3- Finally in Eclipe's package explorer:
 - Rigth click on the project folder -> Run As -> Run on Server
 
-- NOTE --
If deployment runs into the next Exception:
java.lang.ClassNotFoundException: com.sun.jersey.spi.container.servlet.ServletContainer

 - Rigth click on the project folder -> Properties -> Deployment Assembly -> Add ->
 Java Build Path Entries -> Maven Dependencies -> Finish -> Apply and close
 
 - Restart tomcat server
 
 
With this steps the server should be on, then try running the endpoint with Postman
following the endpoint's documentation on swagger.txt.