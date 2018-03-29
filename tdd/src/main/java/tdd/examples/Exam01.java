package tdd.examples;

import java.lang.reflect.Method;
//reflection을 이용하면 메서드 이름을 통해 메소드 실행 가능

public class Exam01 {
    public static void main(String[] args)
            throws Exception{
        // "tdd.examples.MyUtil"이름에 해당하는 클래스를
        // classpath에서 찾는다. 그 클래스 정보를 메모리에 올린다.
        // static 변수는 메모리에 올라간다. static block이 실행된다.
        // JDBC에서 driver load와 관련된 개념.
        Class clazz = Class.forName("tdd.examples.MyUtil");
        //Class는 정보를 알 수 있다.
        System.out.println(MyDriver.getName());
        // 인스턴스 생성
        Object obj = clazz.newInstance();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //모든 메소드의 메소드 이름을 출력한다.
        for(Method method : declaredMethods){
            System.out.println(method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            for(Class ptype : parameterTypes){
                System.out.println(ptype.getName());
            }
            Class<?> returnType = method.getReturnType();
            if(returnType !=null)
                System.out.println("return type : " + returnType.getName());
            System.out.println("-------------------------");

        }

    }
}

class MyUtil{
    static{
        MyDriver.setName("MyUtilDriver");
//        System.out.println("static block");
    }
    @MyTest
    public void print1(){
        System.out.println("print1");
    }
    @MyTest
    public String getName(){
        return "urstory";
    }
    public void setName(String name){
        System.out.println(name + "으로 설정합니다.");
    }
}

class MyDriver{
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MyDriver.name = name;
    }
}


//질문 : MyDriver는 아직 메타스페이스에 올라가지 않았을까?