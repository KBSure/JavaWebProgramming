package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        CDPlayer player = context.getBean(CDPlayer.class);
        player.play();

        CDPlayer2 player2 = context.getBean(CDPlayer2.class);
        player2.play();


//        SgtPeppers sgtPeppers = context.getBean("sgtPeppers", SgtPeppers.class);
//        sgtPeppers.play();
    }
}
