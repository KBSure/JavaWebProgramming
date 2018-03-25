package examples;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelloMain {
    public static void main(String[] args)
                             throws Exception {
        //    Hello hello1 = new Hello1();
        //    Hello hello2 = new Hello2();
//        Hello hello = new Hello1();


        for(int i =1; i <=3; i++){
            String className = "examples.Hello" + i;
            Class clazz = Class.forName(className);

//            Method[] method = clazz.getMethods();
//            for(Method m : method){
//                System.out.println(m);
//            }

            Hello hello = (Hello)clazz.newInstance();
            hello.hello();
        }
//        hello.hello();
    }
}
