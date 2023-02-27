package com.javaAdvanced.multithreading;


public class Ex_4 {

    public static void main(String[] args) {

        Ex4Thread ex4Thread = new Ex4Thread();
        ex4Thread.setPriority(10);
        System.out.println("Name of thread: " + ex4Thread.getName() +
                "\n Priority of thread: " + ex4Thread.getPriority() );


        Ex4Thread ex4Thread2 = new Ex4Thread();
        ex4Thread2.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Name of thread: " + ex4Thread2.getName() +
                "\n Priority of thread: " + ex4Thread2.getPriority() );


    }
}

class Ex4Thread extends  Thread {
    @Override
    public void run() {
        System.out.println("Anything");
    }
}