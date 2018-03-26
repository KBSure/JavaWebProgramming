package examples;

public class HelloMain {
    public static void main(String[] args)
                            throws Exception{
//      Hello1 hello1 = new Hello1();
        for(int i = 1; i <=2; i++){
//            문자열로 된 클래스 이름을 가지고 인스턴스를 생성하는 법
            String className1 = "examples.Hello" + i;
//            className1에 해당하는 클래스 정보를 clazz에 대입
            Class clazz = Class.forName(className1);
//            clazz가 가지고 있는 정보를 이용해 인스턴스를 생성
            Hello hello = (Hello)clazz.newInstance();
            hello.hello();
        }
    }
}
