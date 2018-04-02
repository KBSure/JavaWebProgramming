package playsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class GameTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/playsystem/GameTest-context.xml");
        Game game = (Game)context.getBean("game");
        game.play();
    }
}
