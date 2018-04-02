package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("exam01.xml");        //classPath에서 exam01.xml을 찾겠다는 것

//        MyBean bean1 = new MyBean(); 이렇게 쓰면 안된다. 내가 만드는 게 아니다.

    }
}
