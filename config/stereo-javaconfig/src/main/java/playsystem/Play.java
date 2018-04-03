package playsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Play {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PlaySystemConfig.class);

        Game game = context.getBean("game", Game.class);
        game.play();
    }
}