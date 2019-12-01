# Toll Road Simulation In Java #
**Monday 25th March 2019 Version 1.0.0**

**Built using netbeans and requires Java SDK 1.8**
### Vehicle class ###
The vehicle class is an abstract base class that contains a registration number and a manufacturer for the vehicles
as well as a method for calculating the cost of the toll road.
### Car, Van and Truck classes ###
The car,van and truck classes are specialised vehicle classes that have specialised attributes as well as the definition
for calculating the trip cost. The car class' specialised attribute is the number of seats that it has, the van class' 
attribute is the payload of the van and the truck's attribute is the number of trailers.
### The customer not found and the insufficient balance exception classes ###
As the class names state, the classes inherit from Java's error base class and throw an error if the customer doesn't
exist or if the customer doesn't have the funds to cross the toll road.
### The TollRoad class ###
The toll road class contains methods for searching, adding and charging the customers of the toll road as well as 
accessors for getting the total income of the toll road and etting the list of customers on the toll road.
### TollRoadMain class ###
The toll road main class contains IO methods for accessing the customers from a text file and then contains a sepearte
method for simulating the toll road system.
