package examples;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies) {
                System.out.println(c.getName() + " : " + c.getValue());
            }
        }
        System.out.println("---------------------------------------");

        //"name"이라는 name 없을 때만 생성해주는 게 로직 상 적합하지만, addCookie가 알아서 처리해주나?
        Cookie cookie = new Cookie("name", "KBS");
        cookie.setPath("/"); //이걸 해줘야 /hello 에서만 적용되는 것을 막을 수 있다.
        resp.addCookie(cookie);

        pw.println("<h1> hello </h1>");
    }

}


