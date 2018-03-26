package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try(ServerSocket lister = new ServerSocket(8080);
            FileOutputStream fileOutputStream = new FileOutputStream("input2.txt");){
            Socket client = lister.accept();
            InputStream inputStream = client.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                if(line.equals("quit"))
                    break;
                printWriter.println(line);
                printWriter.flush();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
