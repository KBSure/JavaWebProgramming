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

            HttpRequest request = new HttpRequest();
            InputStream is = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

            String line = null;

            //HttpRequest에 넣어보기
            line = br.readLine();
            String[] firstLineArgs = line.split(" ");
            request.setMethod(firstLineArgs[0]);
            request.setPath(firstLineArgs[1]);

            while((line = br.readLine()) != null) {
                if("".equals(line))
                    break;
                String[] headerArray = line.split(" ");
                if(headerArray[0].startsWith("Host:")) {
                    request.setHost(headerArray[1]);
                }else if(headerArray[0].startsWith("Content-Length:")) {
                    request.setContentLength(Integer.parseInt(headerArray[1]));
                }else if(headerArray[0].startsWith("User-Agent:")) {
                    request.setUserAgent(line.substring(12));
                }else if(headerArray[0].startsWith("Content-Type")) {
                    request.setContentType(headerArray[1].trim());
                }
            }
            System.out.println(request);

            String body = "<h1>hello world!</h1>";

            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Content-Length: "+ body.length());
            pw.println();
            pw.write(body);
            //pw.println(body);
            pw.flush();

            br.close();
            pw.close();
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

//GET / HTTP/1.1
//        Host: localhost:8080
//        Connection: keep-alive
//        Cache-Control: max-age=0
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
