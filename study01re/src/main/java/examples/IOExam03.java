package examples;

import java.io.FileOutputStream;

public class IOExam03 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("data4.dat");){

            long start = System.currentTimeMillis();
            byte[] buffer = new byte[1024];
            for(int i = 0; i < 1024; i++){
                fos.write(buffer, 0, 1024);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }catch(Exception ex){}
    }
}
