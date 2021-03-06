package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//java config 클래스에는 @Configuration 이 클래스 위에 있어야 한다.
@Configuration
public class CDPlayerConfig {

  // 메소드 이름이 id가 된다 .메소드 이름이 중복되면 id가 중복된다는 의미이기 때문에 안된다.
  // <bean id="compactDisc" class="soundsystem.SgtPeppers"/>
  // Bean 생성을 하는 메소드는 @Bean이 붙어야 한다.
  @Bean
  public CompactDisc compactDisc() {
    System.out.println("compactDisc() 호출");
    return new SgtPeppers();
  }

  @Bean
  public CompactDisc myDisc(){
    System.out.println("myDisc() 호출");
    return new MyDisc();
  }

  // <bean id="cdPlayer" class="soundsystem.CDPlayer">
  //  <construct-arg ref="compactDisc"/>
  // </bean>

  @Bean
  public CDPlayer cdPlayer(CompactDisc compactDisc) {
    System.out.println("cdPlayer() 호출");
    return new CDPlayer(compactDisc);
  }
//CompactDisc가 여러 개 있을 때 파라미터 변수명이 중요하다. 메서드 이름과 같아야 한다.

}
