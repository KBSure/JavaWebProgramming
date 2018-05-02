package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args) {

        ServerSocket listener = null;

        try {
            listener = new ServerSocket(8080);
            System.out.println("Client를 기다립니다.");
            Socket client = listener.accept();
            System.out.println(client.toString());

            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                if("".equals(line))
                    break;
                System.out.println(line);
            }
            bufferedReader.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   finally {
            try {
                listener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
