package DesignPattern.SingletonDesignPattern;

/**
 * SingletonDesignPattern - This design pattern comes under Creational Design Pattern
 * -In this design pattern one instance is maintaned throughout the execution of the program
 * 
 * How to build a Singleton Design Pattern ?
 * Ans- 1. declare a private static variable of the class for only instance
 *      2. create a private constructor to restrict the initialization from other classes
 *      3. create a public static method that returns the instance of the class
 * 
 */
/*
 * this is the example of EagerLoading - in this the instance of Singleton Class is created at the time of class loading ,
 */

public class SingletonClassEagerLoading {

    //Lazy Loading Class
private static final SingletonClassEagerLoading instance= new SingletonClassEagerLoading();

private SingletonClassEagerLoading(){

}
   
public static SingletonClassEagerLoading getInstance(){

    return instance;

}

public void print(){
    System.out.println("Eager Loading Singleton Design Pattern!!!");
}

}


