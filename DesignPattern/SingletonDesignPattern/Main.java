package DesignPattern.SingletonDesignPattern;

public class Main {

public static void main(String[] args) {

    //Calling the SingletonClassEagerLoading
    SingletonClassEagerLoading instance1=SingletonClassEagerLoading.getInstance();
    instance1.print();

    //Calling the SingletonClassLazyLoading
    SingletonClassLazyLoading instance2=SingletonClassLazyLoading.getInstance();
    instance2.print();

    //Calling the BillPughSingleton
    BillPughSingleton instance3=BillPughSingleton.getInstance();
    instance3.print();

}    


}
