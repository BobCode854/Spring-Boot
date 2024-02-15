package com.springboot.Learning;

/**
 *  ---------------- Spring Boot --------------------------
      **) Spring Boot offers a fast way to build applications.
      
     **) It looks at your class path and at the beans you have configured, 
           makes reasonable assumptions about what you are missing, and adds those items.
           
     **) One can focus more on business features and less on infrastructure.
     
     **)  A Spring MVC application also needs a Servlet container, 
             so Spring Boot automatically configures embedded TomCat.
             
     **) Spring Boot does not generate code or make edits to your files. 
            Instead, when you start your application, Spring Boot dynamically 
            wires up beans and settings and applies them to your application context.
            
     **) Main goal of Spring Boot application is to quickly create production ready 
            spring boot application.
            
     **)  Usually JDBC is tough to handle , Spring also provide Library for easy connect
             to database.
     
     **) It helps to remove Tight coupling by mean of DI.
     
     **) Loose coupling helps to write Unit test cases also in best way.
     
     **) spring-context in pom.xml will configure all bean for you (Spring core) 
                  **) One child Interface is ApplicationContext which contain all beans.
                  **) We need not to create object with new  keyword, All bean will be
                        placed inside container which will be taken by Application Context later on.
                 **) We will fetch bean with the  help of class , ClassPathXMLApplicationCOntext.
                 **) This require an XML means we need to configure our bean in an XML format.
                 **) After getting all bean in context object we will use
                         context.getBean(ABC.class) to get ABC bean.
                         
                      
     **) In the web application means in Spring boot , spring-boot-starter-web contain all
            these dependencies to create bean.
            
     
            
       @RestController
      -------------------------
**) Giving RestController means your spring class is now ready to handle web request.
**) @Controller + @ResponseBody


Quest1: )) How to get all the bean name available in an application ? 
 Answer: ) Answer provided in LearningApplication.java
 
 
 Quest2 :)) What is Inversion of Control ?
 Answer : ) Inversion of control means we are giving control to framework itself .
                   **) No need to create object itself, framework will do for you.
                   **) DI (Dependency Injection) We will achieve because of Inversion of control
                         way in Spring.
     
   Ques3 :)) Spring AOP (Aspect Oriented Programming) ?
   Answer :)  Cross Cutting Concern
                        ** ) We separate out  all the  common component for common use.
                        **) Logging , Authentication , Authorization

 Ques4 : )) Scope of an Spring Application ?
 Answer : )  There were 5 scope of an spring application
                       **) Singleton
                       **) Prototype
                       **) Request
                       **) Session
                       **) Global Session
                       
                 In order to change , we have to annotate the class with @Scope(scopeName="out of 5")
                 
   Ques5 :))   Running Spring boot through command line ?
   Answer : )  mvn spring-boot:run
   
   
   Ques 6  : ) Creating Jar for Spring boot application
   Answer : ) mvn clean install
                     
                     **) Once Jar is created we can check in target folder.
                     **) If successfully builded the same Jar we can deploy for different application environment
                               For that , we need to go to target folder 
                                 target > java -jar JarNameWithVersion --spring.profiles.active = PROFILE  --server.port=PORT_NUMBER
                                 
                                 Example : 
                                 
                                      java -jar abc-1.0.0.jar  --spring.profiles.active=prod --server.port=1011
                     
                     
    
 Ques 7 : )  Checking for the actuator
 Answer : ) 
         
                    **) dependency Name : spring-boot-starter-actuator
                    **) /actuator is an end-point which will be exposed.
                   **)  We have to hit this URL once application started : http://localhost:1010/actuator
    
    Ques 8 : )  How to Enable all the  endpoint of actuator
    Ans : 
             **) In application.properties  we have to provide one command
             **) management.endpoints.web.exposure.include = "*";
             * **) management.endpoints.JMX.exposure.include = "*"; // this we can also add but currently not required.
	
 */
public class BasicInfo {

}
