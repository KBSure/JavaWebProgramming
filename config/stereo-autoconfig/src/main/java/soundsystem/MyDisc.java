package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class MyDisc implements  CompactDisc {

    @Override
    public void play() {
        System.out.println("MyDisc play()");
    }
}
