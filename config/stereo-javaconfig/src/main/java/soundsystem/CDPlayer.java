package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  public CDPlayer(){
    System.out.println("CDPlayer 생성자");
  }

  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public CompactDisc getCompactDisc() {
    return cd;
  }

  public void play() {
    cd.play();
  }

}
