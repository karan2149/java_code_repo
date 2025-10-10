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
 * this is the example of LazyLoading - in this the instance of Singleton Class is created only when it is requested
 */
public class SingletonClassLazyLoading {

    private static SingletonClassLazyLoading instance;

    private SingletonClassLazyLoading(){

    }
      /*
   * this will only work in single threaded environment , it will break at multi threaded environment 
   * suppose we have 2 thread and both will check for null , so both of the thread will enter the if condition  
   * and thus it will break it , so to avoid it we will mark this method with $ SYNCHRONIZED $
   */
    public static SingletonClassLazyLoading getInstance(){

        if(instance==null){
            instance= new SingletonClassLazyLoading();
        }
        return instance;

    }

  /*
   * so to avoid it we will mark this method with $ SYNCHRONIZED $
   * however this will result in the performance issue as this is a synchronized block.
   * Drawback - after the singleton is already initialized, the method is still synchronized on every call
   * result in performance degradation
   */
   public static synchronized SingletonClassLazyLoading getSynchronizedInstance(){
    if(instance==null){
        instance=new SingletonClassLazyLoading();
    }
    return instance;
   }

   /*
    * To avoid the performance loss we have another way where synchronized is called only once ,
    * 
    */

    public static SingletonClassLazyLoading getInstanceDoubleLocking(){
        if(instance==null){
             synchronized(SingletonClassLazyLoading.class){
                if (instance==null) {
                    instance=new SingletonClassLazyLoading();
                    
                }
             }
        }
       return instance;
    }
    public void print(){
    System.out.println("Lazy Loading Singleton Design Pattern!!!");
}


    
}
