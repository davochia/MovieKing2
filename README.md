# MovieKing2
An android demo app implemented with movieDb and volley library

Evaluation Of Software Design Pattern on Mobile Application 

Mobile application development is mostly using the Service Oriented Architecture (SOA) for their development processes.  This architecture allows the development of software applications to be loosely coupled between logic and data. In this paper, I will be evaluating the two most used design patterns in mobile application development. 

Design Pattern Categories

Most design patterns popularly used fall into these three categories.

•	Creational patterns Which are centered on object creation
•	Structural patterns, which involves object composition and 
•	The behavioral pattern which deals with object interactions 

The two-design pattern which will be evaluated falls under two categories, and they are the singleton which falls under creational pattern and adapter pattern which falls under structural patterns.


The singleton:  

The singleton is a design pattern that specifies that only one instance of a particular class should be available in the application with global access to the class point. The class makes it possible for an object that shares data across other parts of the application to have the same data or information throughout the phase of the application which might cause problems like mixed data or late data notification. With the singleton, you restrict the creation of more than one instance of the same data and have standardized data across the application. We can access members of the singleton object through a dot call example. 

MySingletonClass.INSTANCE.classMethod();


In the movie king application, the singleton class has been used in the Volley library class which is used for API calls to our application for calling the movie dB API and getting the Movie data required. 


The Adapter pattern:

The adapter pattern is part of the structural design pattern which allows incompatible classes to collaborate by converting or structuring the class interface into the interface of the client that is using it expects. The makes it possible for the different client to use or reuse same class or object with the same interface which is compatible with one another.
 
Usage example includes when new components in our program needed to work together with an existing component in the application. For an API call of third-party services which might change its design. Some advantages include;

-	Reusable code and flexibility. 
-	Clean and simple code using the polymorphism style.

This pattern has been using in our Movie King application for our RecyclerMovieAdapter class. In this class, we have used the adapter pattern to populate our UI with data of the same interface passed into the class instance. 


Mobile design pattern

Model View Controller (MVC)

The model view controller software architecture is widely used by most major programming languages for building software and web applications. The model which encompasses the data and data access layer is responsible for managing the data access or rather business logic area and database. The View is mostly responsible for the UI or presentational layer which displays the data from the application which accesses the model only in a read-only mode.
 
The Controller is the brain or binding layer between the model and view from data transactions among them which comes up when there’s needed to render a new view i.e., it receives all requests from the application and instructs the model to prepare the information required by the view.  The individual components are designed to handle a specific aspect of the application development.

Advantages
-	Support for asynchronous which helps for fast loading.
-	Faster development which makes it possible for the different controller to work in a different component. 
-	Can be used for multiple views which reduces duplicate codes.
-	Changes in the UI will not affect the other components of the application.

Disadvantages 
-	Tightly coupled together which affects its reusability of individual components.
-	Very complex 
-	Not suitable for small applications.


Model View Presenter (MVP)

Parallel in use to the MVC pattern used for a limited set of UI components of simple navigation flow which improve testability. This pattern from the mobile application separates the data model from the view through the presenter layer. The model provides the data and the logic to fetch and update the data through communication with the database or webserver. The View component contains the presentational layer of the application. The presenter is the part of the application that triggers the logic required by the view. 

Advantages
-	The presenter is separated from the lifecycle of the view.
-	There’s no direct communication between the model and the view.

Disadvantages 
-	Manual binding of the components because it doesn’t fit for automated application development. 
-	Assembly problems due to different component layers.
-	Difficult to implement binding logic without processing access to the controls of the user interface. 


Comparison of the MVC and MVP

The MVC is behavior-based. Views can communicate directly with the model and the MVC can share multiple views While in the MVP pattern, the views are more separated from the model. The presenter communicates between the model and view which makes it easier to design a unit test. 

