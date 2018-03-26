package examples;

public class ThreadExam03 {
    public static void main(String[] args) {
        Cube cube = new Cube();
//        Cube cube2 = new Cube();
        MyThread03 t1 = new MyThread03(cube, 1);
        MyThread03 t2 = new MyThread03(cube, 2);
        MyThread03 t3 = new MyThread03(cube, 3);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Cube{
    public void a(){
        for(int i = 0; i < 10; i++){
            System.out.print("a");
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception e){}
        }
    }

    public synchronized void b(){
        for(int i = 0; i < 10; i++){
            System.out.print("b");
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception e){}
        }
    }

    public synchronized void c(){
        for(int i = 0; i < 10; i++){
            System.out.print("c");
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch(Exception e){}
        }
    }
}

class MyThread03 extends Thread{
    private Cube cube;
    private int flag;
    public MyThread03(Cube cube, int flag){
        this.cube = cube;
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag == 1)
            cube.a();
        else if(flag == 2)
            cube.b();
        else if(flag == 3)
            cube.c();
    }
}