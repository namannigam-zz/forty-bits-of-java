package edu.forty.bits.functional;

public class PrintingMethodName {

    public static void main(String[] args) {
	// write your code here
        MyMethod();
    }


    private static void MyMethod(){
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getId());
//        System.out.println(Thread.currentThread().getStackTrace().length);
        StackTraceElement[] details = Thread.currentThread().getStackTrace();
        for(int i=0;i<Thread.currentThread().getStackTrace().length;i++){
            System.out.println(details[i].getMethodName());
//            System.out.println(details[i].getClassName());
            System.out.println(details[i].getLineNumber());
            System.out.println(details[i].getFileName()); //Returns the class file name of called
        }
    }
}