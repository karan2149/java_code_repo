package DesignPattern.SingletonDesignPattern;

import java.lang.reflect.Constructor;

/*
 * This class is used to break Singleton Design Pattern 
 * 1.Using Reflection - In this we use Constructor to break it 
 */
public class BreakSingleton {
public static void main(String[] args) {

    SingletonClassEagerLoading instance1 = SingletonClassEagerLoading.getInstance();
    SingletonClassLazyLoading instance2=null ;

    SingletonClassEagerLoading instanceEager1=SingletonClassEagerLoading.getInstance();
    SingletonClassEagerLoading instanceEager2=null ;
    
    BillPughSingleton instanceBillPugh1 = BillPughSingleton.getInstance();
    BillPughSingleton instanceBillPugh2 = null;
    
  Constructor<?>[] declaredConstructors = SingletonClassLazyLoading.class.getDeclaredConstructors();
 Constructor<?>[] declareConstructorsForEager= SingletonClassEagerLoading.class.getDeclaredConstructors();
Constructor[] declaredConstructorsForBillBugh=BillPughSingleton.class.getDeclaredConstructors();


 //for loop for the lazy loading singleton pattern 
for(Constructor constructor:declaredConstructors){
    try {
        constructor.setAccessible(true);
    instance2=(SingletonClassLazyLoading)constructor.newInstance();
    } catch (Exception e) {
e.printStackTrace();    }

}
System.out.println("For Lazy Loading Singleton Breaking");
System.out.println("Instance 1 hashcode:"+instance1.hashCode());
System.out.println("Instance 2 hascode:"+instance2.hashCode());

 //for loop for the eager loading singleton pattern 
for(Constructor eagerConstructor:declareConstructorsForEager){
    try {
       eagerConstructor.setAccessible(true);
instanceEager2=(SingletonClassEagerLoading)eagerConstructor.newInstance();
   } catch (Exception e) {
e.printStackTrace();    }
}
System.out.println("For Eager Loading Singleton Breaking Pattern");
System.out.println("Instance 1 hashcode:"+instanceEager1.hashCode());
System.out.println("Instance 2 hascode:"+instanceEager2.hashCode());



 //for loop for the bill bugh singleton pattern 
for(Constructor billBughConstructor:declaredConstructorsForBillBugh){
    try {
       billBughConstructor.setAccessible(true);
instanceBillPugh2=(BillPughSingleton)billBughConstructor.newInstance();
   } catch (Exception e) {
e.printStackTrace();    }
}
System.out.println("For Bill Bugh Loading Singleton Breaking Pattern");
System.out.println("Instance 1 hashcode:"+instanceBillPugh1.hashCode());
System.out.println("Instance 2 hascode:"+instanceBillPugh2.hashCode());

}
    
    
}
