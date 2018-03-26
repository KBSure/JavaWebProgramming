package examples;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) {
        try(Socket client = new Socket("10.10.118.199", 8080);){
            InputStream inputStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = client.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            String line = null;
            while((line = bufferedReader.readLine()) != null){
                printWriter.println(line);
                printWriter.flush();
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
