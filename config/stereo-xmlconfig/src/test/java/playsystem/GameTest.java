package playsystem;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/playsystem/*.xml")
public class GameTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();
    //System.out으로 출력되는 애들 캡쳐
    @Autowired
    Game game;

    @Test
    public void notNullTest(){
        Assert.assertNotNull(game);
    }

    @Test
    public void play(){
        String expected = "Player1이 던진 주사위가1나왔습니다.\r\n" +
                "Player2이 던진 주사위가4나왔습니다.\r\n" +
                "Player3이 던진 주사위가4나왔습니다.\r\n";

        game.play();
        assertEquals(expected, log.getLog());
    }
    //    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("/playsystem/GameTest-context.xml");
//        Game game = (Game)context.getBean("game");
//        game.play();
//    }
}
