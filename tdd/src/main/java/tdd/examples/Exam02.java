package tdd.examples;

import java.lang.reflect.Method;

public class Exam02 {
    public static void main(String[] args)
            throws Exception{

        String className = "tdd.examples.MyUtil";
        String methodName = "print1"; // print1()

        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();

        Method method = clazz.getMethod(methodName, null);
        if(method != null){
            // obj의 메소드중 method정보에 해당하는 메소드를 실행하라.
            Object returnValue = method.invoke(obj, null );
            if(returnValue != null){
                System.out.println(returnValue.getClass().getName());
            }
        }
    }
}