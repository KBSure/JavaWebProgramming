package soundsystem;

//남이 만든 건데 주입하고 싶을 때

public class TwiceDisc implements CompactDisc {
    @Override
    public void play() {
        System.out.println("twiceDisc.play()");
    }
}
