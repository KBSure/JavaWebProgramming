package examples;

public class ThreadExam02 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread("*"));
        Thread thread2 = new Thread(new MyThread("-"));
        Thread thread3 = new Thread(new MyThread("|"));
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("main stop!!");

    }
}

class MyThread implements Runnable{
    String name;
    MyThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            System.out.print(this.name);
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception e){}
        }
    }
}