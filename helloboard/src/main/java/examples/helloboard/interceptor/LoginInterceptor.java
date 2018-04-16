package examples.helloboard.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //session에서 loginFlag 가져와서

        HttpSession session = request.getSession();
        String loginFlag = (String)session.getAttribute("loginFlag");

        // (login Interceptor가 작동할 path를 따로 저장해놓는다.)
        List<String> securePath = Arrays.asList("/boards/writeform",
                                                "/boards/write",
                                                "/boards/updateform",
                                                "/boars/update");
        String servletPath = request.getServletPath();

        //login 안되어 있다면
        //redirect 시킬지 말지 정한다.
        if(loginFlag == null || "".equals(loginFlag)){
            if(securePath.contains(servletPath)){ //로그인 필요한놈이라면
                //referer
                response.sendRedirect("/boards/loginform/?referer=" + servletPath);
            }
        }



        return super.preHandle(request, response, handler);
    }
}
