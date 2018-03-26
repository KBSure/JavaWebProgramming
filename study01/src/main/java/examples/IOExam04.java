package examples;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOExam04 {
    public static void main(String[] args) throws Exception{
        try(FileOutputStream fos = new FileOutputStream("input.txt");) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            FileOutputStream fos = new FileOutputStream("input.txt");
            String line = null;
            while((line = br.readLine()) != null){
                if("quite".equals(line))
                    break;
                System.out.println(line);
            }

        }catch(Exception ex){
            System.out.println(ex);
        }

    }
}
