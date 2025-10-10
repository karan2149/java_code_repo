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
 * In this the inner static class is used to create the Instance of the Singleton Class
 * (One of the efficient way to declare the Singleton Design Pattern)
 */

public class BillPughSingleton {
    private BillPughSingleton(){

    }


    private static class InnerClass{
        private static final BillPughSingleton instance=new BillPughSingleton();


    }
    public static BillPughSingleton getInstance(){
       return  InnerClass.instance ;
    }
    public void print(){
    System.out.println("Bill Bugh Singleton Design Pattern!!!");
}
    
    /*
     * Here we can observe that the inner class which contain the create instance isn't loading 
     * at the time of class loading ,only when someone calls getInstance() it get loaded 
     */
}
