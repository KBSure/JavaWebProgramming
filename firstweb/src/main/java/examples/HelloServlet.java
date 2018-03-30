package examples;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
http://localhost:8080/hello
HttpServlet클래스는 tomcat이 가지고 있다.
tomcat안에서 웹 애플리케이션이 실행될때는 찾을 수 있다.
컴파일할때는? 없다.....
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); // 오타 나면 안된다.....
        PrintWriter pw = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                System.out.println(c.getName() + " : " + c.getValue());
            }
        }
        System.out.println("---------------------------------------");

        Cookie cookie = new Cookie("name", "urstory");
        cookie.setPath("/");

        resp.addCookie(cookie);

        pw.println("<h1>Hello Servlet</h1>");
    }
}