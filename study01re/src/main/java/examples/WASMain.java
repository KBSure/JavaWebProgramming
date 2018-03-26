package examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args) {
        ServerSocket listener = null;
        try{
            listener = new ServerSocket(8080);
            //serversocket???
            System.out.println("client를 기다립니다.");
            while(true){
                Socket client = listener.accept();
                //socket?? 블러킹 메소드??

                new Thread(() -> {
                    try{
                        handleSocket(client);
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }).start();
//              System.out.println(client);

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                listener.close();
            }catch(IOException ie){}
        }
    }
    private static void handleSocket(Socket socket){
        System.out.println(socket);
    }
}
