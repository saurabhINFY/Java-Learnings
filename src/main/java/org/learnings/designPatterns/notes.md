Q) What do we need Design pattern-
- As Design Patterns are well documented and understood by software architects, designers and developers, then their application within a specific solution will likewise be well understood.
- Patterns give a software developer an array of tried and tested solutions to common problems, thus reducing the technical risk to the project by not having to employ a new and untested design, thus saving time and effort during the implementation stage of the software development lifecycle

Q) What are the Creational Patterns?
- Creational design patterns are related to the way of creating objects.
- This pattern is used to define and describe how objects are created at class instantiation time

Q) What Is Factory Pattern?
- In the Factory pattern, we don't expose the creation logic to the client and refer the created object using a standard interface.

> Steps:
> - create main class which call factory class.
> - Factory class returns required class instance

Q) What Is Abstract Factory Pattern?
- This factory is also called as factory of factories.
- Abstract Factory lets a class returns a factory of classes.
- So, this is the reason that Abstract Factory Pattern is one level higher than the Factory Pattern.

An Abstract Factory Pattern is also known as Kit.

> Steps:
> - create main class which call factory of factory class.
> - Factory of factory / factory Producer creates instance of factory class.
> - Factory class returns required class instance

Q) What Is Singleton Design Pattern?
- Singleton pattern is one of the simplest design patterns in Java.
- This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
- This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.


> Steps:
> - create main class which call CacheImpl Class.
> - CacheImpl class has 2 methods : 1st to load the key value in map and create the cache. 2nd to return the required cloned object. 
> - The main class , parent of all reuired concerete class contains cloning technique. Rest concrete class are normal POJOs, nothing special.

Q) What Is Builder Design Pattern?
- Builder Pattern refers to approach that focuses on constructing a complex object from simple objects using step-by-step approach.

> Major roles used in this design patterns are :
- Complex Object / Final Product – e.g. house – complex object which we will generate with builder design pattern
- Builder – abstract class / interface that defines all ways to create the product. It also has getFinalProduct method that will finally return complex object.
- ConcreteBuilder – multiple Builder Impls that will give different final objects which are complex to design,
- Director: Controls complex object creation. It has 2 main goals : 1st to call appropriate concrete builder class to create correct complex object. 2nd to return that complex object.

What are Proxy Design Patterns?
- It’s a Structural design pattern.
- It lets you provide a substitute or placeholder for another object.
- A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

>Roles in Proxy Design Pattern?
 Major roles used in this design patterns are :
> - Subject – is an interface that exposes the functionality available to be used by the clients.
> - Real Subject – is a class implementing Subject and it is the concrete implementation that needs to be hidden behind a proxy.
> - Proxy – hides the real object by extending it and clients communicate to the real object via this proxy object. Usually, frameworks create this proxy object when the client request for the real object.

> Advantages of Proxy Design Pattern?
> - Access control/protection given by proxy object: This is when you want only specific clients to be able to use the service object.
> - Caching request results (caching proxy). This is when you need to cache results of client requests and manage the life cycle of this cache, especially if results are quite large.
> - Logging requests (logging proxy). This is when you want to keep a history of requests to the service object.

What is Flyweight Design Patterns?
 - It’s a Structural design pattern.
 - A flyweight is a shared object that can be used in multiple contexts simultaneously. The flyweight acts as an independent object in each context.

Where to use Flyweight DP?
 - When your application needs large number of objects that shares most of the common attributes called Intrinsic Attributes or properties and only few unique attributes called as Extrinsic attributes / properties.

 - We need to control the memory consumption by large number of objects – by creating fewer objects and sharing them across.

When to use Flyweight DP?
- The number of Objects to be created by application should be huge.
- The object creation is heavy on memory and it can be time consuming too.
- The object properties can be divided into intrinsic and extrinsic properties, extrinsic properties of an Object should be defined by the client program.
