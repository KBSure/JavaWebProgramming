package tdd.examples;

public class Exam05 {
    public static void main(String[] args) {
        MyBean bean = new MyChildBean();
        bean.run();
    }
}

abstract class MyBean{
    public abstract void run();
}

class MyChildBean extends MyBean{
    @Override
    public void run() {
        System.out.println("run!");
    }
}