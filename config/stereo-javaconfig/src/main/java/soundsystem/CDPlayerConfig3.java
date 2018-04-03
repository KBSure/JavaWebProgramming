package soundsystem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig3 {

  // 파라미터 이름에 해당하는 메소드 이름이 있어도 @Qualifier("myDisc")이 우선한다.(이긴다!)
  @Bean
  public CDPlayer cdPlayer(@Qualifier("myDisc")CompactDisc compactDisc) {
    System.out.println("cdPlayer() 호출");
    return new CDPlayer(compactDisc);
  }

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


//CompactDisc가 여러 개 있을 때 파라미터 변수명이 중요하다. 메서드 이름과 같아야 한다.

}
