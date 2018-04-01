package examples;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class HiServlet extends HttpServlet {
    //session 으로 key="name", value="KBSure"으로 구성된 session하나 만들어서 sessionID 발급해주는 것
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        HttpSession session = req.getSession();
        String name = (String)session.getAttribute("name");
        if(name == null){
            session.setAttribute("name","KBSure");
        }else{
            System.out.println(name);
        }

        pw.println("<h1> Hi </h1>");
    }
}
