package examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
http://localhost:8080/number

http://localhost:8080/number?num=100 // 물음표 이하 부분을 파라미터 (name=값 & name=값 )
 */
@WebServlet(name = "NumberGameServlet", urlPatterns = "/number")
public class NumberGameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // 오타 나면 안된다.....
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();

        String value = request.getParameter("num"); // ?num=100 , 파라미터가 없으면 null이 반환된다.
        if(value == null){
            session.setAttribute("randomValue", (int)(Math.random() * 100) + 1);
            session.setAttribute("counter", 0);
        }else{
            try {
                int numValue = Integer.parseInt(value);
                int randomValue = (Integer)session.getAttribute("randomValue");
                int counter = (Integer)session.getAttribute("counter");
                if(numValue == randomValue){
                    pw.println("OK!!  <br>" + counter + "<br><a href='/number'>restart</a>");
                }else if(numValue < randomValue){
                    pw.println("numValue < randomValue <br>");
                    session.setAttribute("counter", counter + 1);
                }else if(numValue > randomValue){
                    pw.println("numValue > randomValue <br>");
                    session.setAttribute("counter", counter + 1);
                }
            }catch(Exception ex){

            }
        }
        // 처음 실행(파라미터가 없을 경우)하면 0번째 도전입니다. 세션에 1~100 중의 한개의 값을 저장한다.
        // 두번째 이후부터는 사용자가 입력한 값과 저장된 값을 비교.
        // 사용자가 입력한 값과 저장된 값이 일치할 경우 .

        pw.println("<form method='get' action='/number'>");
        pw.println("1 ~ 100 : <input type='text' name='num'><br>");
        pw.println("<input type='submit'>");
        pw.println("</form>");
    }


}