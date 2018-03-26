package examples;

public class Hello1 implements Hello{
    public void hello(){
        System.out.println("hello1");
    }
}

//어떤 클래스일지 정의는 안되어 있지만 어떤 클래스가 계속 추가될 것이다.
//hello라는 메서드는 사용된다.

//class : Hello1 ~ Hello100
//method : hello()
//Hello1 ~ Hello10 인스턴스를 만든 후 hello() 메서드를 호출하라.

