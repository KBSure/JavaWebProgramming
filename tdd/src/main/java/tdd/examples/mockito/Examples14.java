package tdd.examples.mockito;

import java.util.List;

import static org.mockito.Mockito.*;

/*
mock을 초기화를 위해서는 reset()을 사용하면 된다.
사실 간단히 새로 mock을 하나 만들면 되기 때문에 거의 쓸 일은 없을 것이다.
 */
//특히 JUnit과 같이 쓸 떄 before를 쓰거나 위에 @쓰는 걸로 할 때 초기화한다 그래서 필요없다
public class Examples14 {
    public static void main(String[] args) {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(10);
        mock.add(1);

        reset(mock);
    }
}

