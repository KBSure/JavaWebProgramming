package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("exam01.xml");        //classPath에서 exam01.xml을 찾겠다는 것
//        xml 파일 읽어들여서 bean 설정 클래스파일을 쫙 올려줆? 어디에? 메모리에?
//        MyBean bean1 = new MyBean(); 이렇게 쓰면 안된다. 내가 만드는 게 아니다.

//       Spring은 기본적으로 객체를 싱글턴으로 관리한다.
        MyBean bean1 = (MyBean)context.getBean("bean1");
        //id가 bean1인 걸 달라
        bean1.setName("홍길동");

        MyBean bean2 = (MyBean)context.getBean("bean1");
        System.out.println(bean2.getName());

        MyBean bean5 = context.getBean(MyBean.class);
           //id가 아닌 class타입으로 달라고 할 때는 설정이 하나만 되어 있어야 한다.
        System.out.println(bean5.getName());

        MyBean bean6 = context.getBean("bean1", MyBean.class);
            //형변환 하지 않고, 객체를 참조하려면 ID, class타입을 인자로 사용해서 getBean 호출

//        MyBean bean3 = (MyBean)context.getBean("bean2");
//        System.out.println(bean3.getName());

//        bean3라는 id의 빈은 설정되어 있지 않기 때문에 Exception이 발생한다.
//        MyBean bean4 = (MyBean)context.getBean("bean3");
//        System.out.println(bean4.getName());
    }
}
