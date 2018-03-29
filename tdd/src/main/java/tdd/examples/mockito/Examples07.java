package tdd.examples.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.List;

import static org.mockito.Mockito.*;

//JUnit과 같이 쓰임
public class Examples07 {
    @Mock private List mockedList;

    // mockedList = mock(List.class); 를 자동으로 해줆 @Mock에 대해서 initMocks()에서 자동으로 해줆.
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this); // mock all the field having @Mock annotation
    }

    @Test
    public void test() {
        // test here
        mockedList.add("one");

        verify(mockedList).add("one");
    }
}
