package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//CDPlayer2 보다 좋은 객체다. 왜냐하면 SPring을 쓰지 않더라도 사용 가능.
//POJO화 될 수 있다.

@Component
public class CDPlayer implements MediaPlayer {

  private CompactDisc cd;

//  @Autowired
  // 기본생성자가 없을 경우 스프링은 최대한 파라미터에 값을 넣어서 인스턴스 생성을 하려고 노력한다.
  // Spring 4.1부터는 생성자에 @Autowired를 안붙여도, 자동으로 주입을 한다. (생성자가 하나 일 때)
  public CDPlayer(@Qualifier("twiceDisc") CompactDisc cd) {
    System.out.println("CDPlayer 생성자");
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

}
