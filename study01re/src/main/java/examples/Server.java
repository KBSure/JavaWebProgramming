package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(8080);
        Socket client = listener.accept();
        InputStream is = client.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String fileName = br.readLine();
        FileOutputStream fos = new FileOutputStream(fileName+".txt");
        PrintWriter pw = new PrintWriter(fos);

        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
            if(line.equals("quit"))
                break;
            pw.println(line);
            pw.flush();
        }
        pw.close();
    }
}
