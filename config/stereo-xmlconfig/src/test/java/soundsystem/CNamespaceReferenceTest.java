package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Junit이 실행하면서
//test할 때 ApplicationContext를 내부적으로 생성 (class 객체랑 상관있는 것)
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext가 생성할 때 클래스이름-context.xml 파일을 설정파일로 하여 읽어들이도록 한다..
@ContextConfiguration
public class CNamespaceReferenceTest {

  //System.out.println(값)으로 출력한 결과를 가질 수 있는 객체.
  @Rule
  public final StandardOutputStreamLog log = new StandardOutputStreamLog();

  //자동으로 DI(의존성 주입)
  //ApplicationContext가 관리하는 Bean중에 MediaPlayer타입의 객체를 주입.
  @Autowired
  private MediaPlayer player;

  @Test
  public void notNull(){
    assertNotNull(player);
  }
  @Test
  public void play() {
    player.play();
    assertEquals(
        "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n",
        log.getLog());
  }

}
