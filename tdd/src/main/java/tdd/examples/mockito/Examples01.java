package tdd.examples.mockito;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// Mocking과 Verification
public class Examples01 {
    public static void main(String[] args){
        // mock
        List mockedList = mock(List.class);
        //~.class
        //실행시에 list 구현한 객체가 하나 동적으로 만들어 리턴

        // mock 사용하기
        mockedList.add("two");
        mockedList.clear();

        // verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}

//언제씀?