package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "GuestbookListServlet", urlPatterns = "/list")
public class GuestbookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GuestbookService service = GuestbookService.getService();
        Iterator<Guestbook> iter = service.getGuestbooks();
        request.setAttribute("iter", iter);

        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/list.jsp");
//        requestDispatcher.forward(request, response);


    }

    @Override
    public void destroy() {
        System.out.println("destroy가 호출됩니다.");
        GuestbookService service = GuestbookService.getService();
        service.save();
    }
}