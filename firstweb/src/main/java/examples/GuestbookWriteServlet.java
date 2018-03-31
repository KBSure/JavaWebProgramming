package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "GuestbookWriteServlet", urlPatterns = "/write")
public class GuestbookWriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // <input type="text" name="name"><br>
        String name = request.getParameter("name");
        //  <textarea cols="60" rows="7" name="content"></textarea><br>
        String content = request.getParameter("content");

        GuestbookService service = GuestbookService.getService();
        Guestbook guestbook = new Guestbook();
        guestbook.setName(name);
        guestbook.setContent(content);
        guestbook.setRegdate(new Date());
        service.addGuestbook(guestbook);

        response.sendRedirect("/list");

    }
}