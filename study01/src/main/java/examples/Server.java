package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try(ServerSocket listener = new ServerSocket(8080);
            FileOutputStream fileOutputStream = new FileOutputStream("input3.txt");){
            Socket client = listener.accept();
            InputStream inputStream = client.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                if(line.equals("quit"))
                    break;
                System.out.println(line);
                printWriter.println(line);
                printWriter.flush();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
