package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam03 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig3.class);

        CDPlayer cdPlayer = context.getBean("cdPlayer", CDPlayer.class);
        cdPlayer.play();
    }
}
