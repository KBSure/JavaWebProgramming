package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Spring을 안 쓰게 되면 활용이 불가능하다.
//Spring에 의존성이 높다.
//byte조작으로 Spring이 주입하는 것임

@Component
public class CDPlayer2 implements MediaPlayer {
  // 필드명 위에 Autowired 적어주면 CompactDisc를 자동으로 주입받는다.
//  @Autowired
//  @Qualifier("myDisc")
  private CompactDisc cd;

  @Autowired
  @Qualifier("myDisc")
  public void asasdfastterCd(CompactDisc cd) {
    this.cd = cd;
  }

  //setter는 자동주입은 안됨
  //생성자 하나일 때 자동주입 가능

  public void play() {
    cd.play();
  }

}
