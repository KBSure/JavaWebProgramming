package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam02 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("exam02.xml"); //exam02.xml 읽자마자 bean 인스턴스 쫘악 생성
        System.out.println("ApplicationContext 생성 이후");
        MyBean bean1 = context.getBean("bean1", MyBean.class);
        System.out.println(bean1.getName());
        System.out.println(bean1.getCount());
        MyBean bean2 = context.getBean("bean1", MyBean.class);

        MyBean bean3 = context.getBean("bean2", MyBean.class);
        System.out.println(bean3.getName());
        System.out.println(bean3.getCount());

        MyBean bean4 = context.getBean("bean3", MyBean.class);
        System.out.println(bean4.getValue("1"));


        if(bean1 == bean2){
            System.out.println("bean1 == bean2");
        }else{
            System.out.println("bean1 != bean2");
        }

    }
}
