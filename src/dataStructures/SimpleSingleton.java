package dataStructures;

/*
 * Java Singleton Design Pattern Tutorial.
 By Viral Patel on January 14, 2009
 Java Singleton design pattern is one of the design pattern that governs the instantiation of an object in Java. This design pattern suggest that only one instance of a Singleton object is created by the JVM. This pattern is useful when exactly one object is needed to coordinate actions across the system. Also it can be generalized to restrict the objects to certain number of instances like say 5 objects only.
 Related: Free Design Pattern Reference Card
 Class diagram of Singleton class
 Following is the class diagram of a singleton class. The constructor is kept private to avoid normal instantiation of objects and all the instantiations are done only through getInstance() method.

 How the Singleton pattern works?
 Following is the source of simple class that follows singleton pattern.
 public class SimpleSingleton {
 private static SimpleSingleton INSTANCE = new SimpleSingleton();

 //Marking default constructor private 
 //to avoid direct instantiation.
 private SimpleSingleton() {
 }

 //Get instance for class SimpleSingleton
 public static SimpleSingleton getInstance() {
 return INSTANCE;
 }
 }
 In above code snippet, we have declared a static object reference to SimpleSingleton class called INSTANCE and is returned every time getInstance() is called. In this design, the object will be instantiate when the class will be loaded and before the method getInstance() is being called. Demand loading (lazy loading) also called initialization on demand holder idiom is not seen in this implementation.
 We can change this code to add lazy init (Instantiate only when first time getInstance() is called) into this. Following is the code snippet for that.
 public class SimpleSingleton {
 private SimpleSingleton singleInstance = null;

 //Marking default constructor private 
 //to avoid direct instantiation.
 private SimpleSingleton() {
 }

 //Get instance for class SimpleSingleton
 public static SimpleSingleton getInstance() {

 if(null == singleInstance) {
 singleInstance = new SimpleSingleton();
 }

 return singleInstance;
 }
 }
 Do you need Singleton pattern?
 Singletons are useful only when you need one instance of a class and it is undesirable to have more than one instance of a class.
 When designing a system, you usually want to control how an object is used and prevent users (including yourself) from making copies of it or creating new instances. For example, you can use it to create a connection pool. It’s not wise to create a new connection every time a program needs to write something to a database; instead, a connection or a set of connections that are already a pool can be instantiated using the Singleton pattern.
 The Singleton pattern is often used in conjunction with the factory method pattern to create a systemwide resource whose specific type is not known to the code that uses it. An example of using these two patterns together is the Abstract Windowing Toolkit (AWT). In GUI applications, you often need only one instance of a graphical element per application instance, like the Print dialog box or the OK button.
 Problems with Singletons
 A simple design pattern like Singleton also has few problem:
 Construct in a multi-thread environment
 It may happen that in a multi-threaded environment two or more threads enter the method getInstance() at the same time when Singleton instance is not created, resulting into simultaneous creation of two objects.
 Such problems can be avoided by defining getInstance() method synchronized.
 public static synchronized SimpleSingleton getInstance() { }
 Cloning can spoil the game
 Although we have taken enough precaution to make the Singleton object work as singleton, Cloning the object can still copy it and result into duplicate object. The clone of the singleton object can be constructed using clone() method of the object. Hence it is advisable to overload clone() method of Object class and throw CloneNotSupportedException exception.
 public Object clone() throws CloneNotSupportedException {

 throw new CloneNotSupportedException();

 }
 The Singleton pattern is widely used and has proved its usability in designing software. Although the pattern is not specific to Java, it has become a classic in Java programming.
 * */

public class SimpleSingleton {
	private static SimpleSingleton singleInstance = new SimpleSingleton();

	// Marking default constructor private
	// to avoid direct instantiation.
	private SimpleSingleton() {
	}

	// Get instance for class SimpleSingleton
	public static SimpleSingleton getInstance() {

		return singleInstance;
	}
}

/*
 * Different Implementation public enum SimpleSingleton { INSTANCE; public void
 * doSomething() { } }
 * 
 * //Call the method from Singleton: SimpleSingleton.INSTANCE.doSomething();
 */