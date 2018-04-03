package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam02 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig2.class);

        CompactDisc myDisc = context.getBean("myDisc", CompactDisc.class);
        CDPlayer cdPlayer = context.getBean("cdPlayer", CDPlayer.class);

    }
}
