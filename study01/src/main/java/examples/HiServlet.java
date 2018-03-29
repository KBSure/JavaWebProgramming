package examples;

import java.io.OutputStream;
import java.io.PrintWriter;

public class HiServlet extends Servlet{
    public HiServlet(){
        System.out.println("HiServlet");
    }

    @Override
    public void init() {
        System.out.println("Hi Servlet Init");
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        PrintWriter pw = response.getOut();

        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html");
        pw.println();

        for(int i = 0; i < 5; i++){
            for(int k = 0; k <=i; k++){
                pw.println("*");
            }
            pw.println("</br>");
        }
        pw.println("<h1>hi servlet</h1>");
        pw.flush();
    }
}