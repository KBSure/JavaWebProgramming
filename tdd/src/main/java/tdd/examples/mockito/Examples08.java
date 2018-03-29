package tdd.examples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

//Mock객체 만드는 두 번쨰 방법
@RunWith(MockitoJUnitRunner.class)
public class Examples08 {
    @Mock
    private List mockedList;

    @Test
    public void test() {
        // test here
    }
}
