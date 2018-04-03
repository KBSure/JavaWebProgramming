package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig2 {

  // config 자바클래스를 Annotation~ApplicationContext가 byte코드로 변환(메서드가 오버라이딩 되어서 사용)
  // 한 번도 호출된 적 없을 경우에 한 번 호출한다. -> 싱글턴이 보장된다.
  // 호출은 변형된 클래스에서 호출.

  // Bean을 생성하는 메소드는 2번째 호출될 경우
  @Bean
  public CDPlayer cdPlayer() {
    System.out.println("cdPlayer() 호출");
    return new CDPlayer(myDisc());
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
