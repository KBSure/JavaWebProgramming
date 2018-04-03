package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class); //javaconfig 파일을 읽어들이는 A.C
        //IoC 컨테이너임, bean객체 생성, 관리, 제어의 역전
        CompactDisc compactDisc1 = context.getBean("compactDisc", CompactDisc.class);
        CompactDisc compactDisc2 = context.getBean("compactDisc", CompactDisc.class);
        if(compactDisc1 == compactDisc2){
            System.out.println("compactDisc1 == compactDisc2");
        }

        CompactDisc myDisc = context.getBean("myDisc", CompactDisc.class);
        myDisc.play();

        CDPlayer cdPlayer = context.getBean("cdPlayer", CDPlayer.class);
        cdPlayer.play();
    }
}
