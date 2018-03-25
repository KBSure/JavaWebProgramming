package examples.boot.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    /hello가 path에 붙으면 return한 값이 출력 메커니즘은 몰라 아직
    @GetMapping("/hello")
    public String sayHello(){
        return "hello!";
    }
}

//http://localhost:8080/hello

//mvn clean : 초기화
//mvn package : 빌드, 패키지까지 생성
//mvn spring-boot:run : Spring boot 웹 어플리케이션 실행