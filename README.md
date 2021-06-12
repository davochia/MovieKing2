# MovieKing2
An android demo app implemented with movieDb and volley library

Evaluation Of Software Design Pattern on Mobile Application 

Mobile application development is mostly using the Service Oriented Architecture (SOA) for their development processes.  This architecture allows development of software applications to be loosely coupled between logic and data. In this paper I will be evaluating two most used design pattern in mobile application development. 

Design Pattern Categories

Most design patterns popularly used falls into these three categories.

•	Creational patterns Which are centered on object creation
•	Structural patterns, which in involves object composition and 
•	Behavioral pattern which deals with object interactions 

The two-design pattern which will be evaluated falls under two categories, and they are the singleton which falls under creational pattern and adapter pattern which falls under structural patterns.


The singleton:  

The singleton is a design pattern which specifies that only one instance of a particular class should be available in the application with a global access to the class point. The class makes it possible for an object that share data across other part of the application to have the same data or information throughout the phase of the application which might cause problems like mix data or late data notification. With the singleton, you restrict the creation of more than one instance of the same data and have standardized data across the application. We can access members of the singleton object through a dot call example. 

MySingletonClass.INSTANCE.classMethod();


In the movie king application, the singleton class has been used in the Volley library class which is used for API calls to our application for calling the movie dB API and getting the Movie data required. 


Th Adapter pattern:

The adapter pattern is part of the structural design pattern which allows incompatible classes to collaborate by converting or structuring the class interface into the interface of the client that is using it expects. The makes it possible for different client to use or reuse same class or object with same interface which are compatible with one another.
 
Usage example includes when new components in our program needed to work together with an existing component in the application. For an API call of third-party services which might change its design. Some advantages includes;

-	Reusable code and flexibility. 
-	Clean and simple code using the polymorphism style.

This pattern has been using in our Movie King application for our RecyclerMovieAdapter class. In this class, we have used the adapter pattern to populate our UI with data of the same interface passed into the class instance. 
