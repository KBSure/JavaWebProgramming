package examples;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("172.30.1.3", 8080);
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);

        String fileName = br.readLine();
        pw.println(fileName);
        pw.flush();

        String line = null;
        while((line = br.readLine()) != null){
            pw.println(line);
            pw.flush();
            if("quit".equals(line))
                break;
        }

        pw.close();
    }

}
