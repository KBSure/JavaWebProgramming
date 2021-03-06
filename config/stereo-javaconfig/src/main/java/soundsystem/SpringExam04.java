package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam04 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig4.class);

        CompactDisc compactDisc1 = context.getBean("compactDisc", CompactDisc.class);
        CompactDisc compactDisc2 = context.getBean("compactDisc", CompactDisc.class);
        if(compactDisc1 == compactDisc2){
            System.out.println("compactDisc1 == compactDisc2");
        }else{
            System.out.println("compactDisc1 != compactDisc2");
        }
    }
}
