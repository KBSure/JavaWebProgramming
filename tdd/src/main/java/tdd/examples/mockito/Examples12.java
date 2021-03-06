package tdd.examples.mockito;

import org.mockito.ArgumentMatcher;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

// anyInt(), anyString()의 커스터마이즈 버전이다. stub, verification 용으로 쓸 수 있다.
// 클래스를 상속해서 matches()를 직접 구현하면 된다. 여러 곳에 재사용할 일이 경우 사용하면 좋다.
public class Examples12 {
    public static void main(String[] args) {
        List mock = mock(List.class);
        when(mock.addAll(argThat(new ListOfTwoElements()))).thenReturn(true);

        mock.addAll(Arrays.asList("one", "two")); // true
        //true 아니면 에러??? 아직 모름 확인해보자

        verify(mock).addAll(argThat(new ListOfTwoElements()));
    }
}


class ListOfTwoElements extends ArgumentMatcher<List> {
    @Override
    public boolean matches(Object argument) {
        List list = (List)argument;
        return list.size() == 2;
    }
}

//이정도로 쓴다는 건 고급스럽게 사용한다는 방증.