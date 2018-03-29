package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
http://lcalhost:8080/hi
 */
//서블릿을 직접 만들필요는 없지만 어떻게 만들고 어떻게 동작하는 지 알아야한다.
//아래 것은 web.xml에 등록하는 걸 대신한다.

@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); //오타 금지
        PrintWriter pw = response.getWriter();

        pw.println("<h1>Hi Servlet</h1>");
    }
}
