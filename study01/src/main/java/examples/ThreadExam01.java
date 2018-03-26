package examples;

import java.util.Random;

public class ThreadExam01 {
    public static void main(String[] args) {
        MyThread01 thread1 = new MyThread01("*");
        MyThread01 thread2 = new MyThread01("-");
        MyThread01 thread3 = new MyThread01("|");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("end!!!");
    }
}

class MyThread01 extends Thread{
    private String name;
    public MyThread01 (String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            System.out.print(this.name);
            try {
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception ex){}
        }


    }
}