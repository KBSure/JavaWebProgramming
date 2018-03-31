package examples;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
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

        requestDispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() throws IOException {

        FileOutputStream fos = new FileOutputStream("guestbook.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Iterator<Guestbook> it = GuestbookService.getService().getGuestbooks();

        ArrayList<Guestbook> list = new ArrayList<>();

        while(it.hasNext()){

            it.next()

        }

        oos.writeObject(GuestbookService.getService());

        oos.close();
    }


}