package tdd.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstTest {
    //테스트 대상은 필드로 선언
    //init은 각 test 메서드 전에 반드시 실행된다.
    MyUtil myutil;
    @Before
    public void init(){
        myutil = new MyUtil(); //초기화  '오염됐다'라고 표현하는데, 객체의 데이터가 변경되었을 수도 있으므로. 초기화된 객체를 통해 테스트한다는 것.
        System.out.println("init");
    }
    @Test
    public void test1() throws Exception{
        System.out.println("test1");
    }
    @Test
    public void test2() throws Exception{
        System.out.println("test2");
    }
    @Test
    public void test3() throws Exception{
        System.out.println("test3");
    }
    @After
    public void destroy(){
        myutil = null;
        System.out.println("destroy");
    }
//메서드 선언 순서는 테스트 순서와 상관없다.
}


//질문 : Annotaion이 영향을 주는 시점은? compile??

//Junit은 Reflection으로 만들어졌다. Annotation이 어떻게 사용된다