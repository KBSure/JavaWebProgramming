package tdd.examples;

import java.lang.annotation.*;

// MyTest 라는 애노테이션을 작성한다.
@Target(ElementType.METHOD)
//(위)메소드에 붙을 수 있는 Ann
@Retention(RetentionPolicy.RUNTIME)
@Documented
//(아래)@interface는 Ann을 정의하는 거다.
public @interface MyTest {

}