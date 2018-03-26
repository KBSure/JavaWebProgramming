package examples;

public class ThreadExam03 {
    public static void main(String[] args) {
        Cube cube = new Cube();
        MyThread t1 = new MyThread(cube, 1);
        MyThread t2 = new MyThread(cube, 2);
        MyThread t3 = new MyThread(cube, 3);
        t1.start();
        t2.start();
        t3.start();
    }
}


class Cube {

    public void a(){
        for(int i = 0; i < 10; i++){
            System.out.print("a");
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void b(){
        for(int i = 0; i < 10; i++){
            System.out.print("b");
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void c(){
        for(int i = 0; i < 10; i++){
            System.out.print("c");
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread{
    private int flag;
    private Cube cube;

    MyThread(Cube cube, int flag){
        this.cube = cube;
        this.flag = flag;
    }
    @Override
    public void run() {
        if(this.flag == 1){
            cube.a();
        }else if (this.flag == 2){
            cube.b();
        }else if (this.flag == 3){
            cube.c();
        }
    }

}