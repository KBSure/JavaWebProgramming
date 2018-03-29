package tdd.examples.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/*
spy()는 진짜 인스턴스를 mock하는 것이다. 당연히 spy된 인스턴스를 stub 할 수 있다.
단, 어떤 경우는 stub 할 때 조심해야 한다. 위의 when(spy.get(10))에서는 진짜 인스턴스의 메소드를 호출하기 때문에 IndexOutOfBountException이 발생하게 된다.
이럴 경우 doReturn()를 사용해서 문제를 회피할 수 있다.
 */
@RunWith(MockitoJUnitRunner.class)
public class Examples11 {

    @Test
    public void test() {
        List list = new LinkedList();
        List spy = spy(list); //실제 list메소드 다 사용 가능

        when(spy.size()).thenReturn(100); // stubbing

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0)); // one
        System.out.println(spy.size()); // 100

        verify(spy).add("one");
        verify(spy).add("two");

// Wrong use case
//        when(spy.get(10)).thenReturn("foo"); // IndexOutOfBoundsException

        //list는 실제로 구현되어있는 인스턴스이므로, 오류

// use doReturn() instead
//        doReturn("foo").when(spy).get(0);
        when(spy.get(0)).thenReturn("foo");
        System.out.println(spy.get(0));
    }
}

//spy는 잘 써야 해서 사실 추천하는 객체는 아님
//mock을 쓰면 일일이 다 써야하므로 귀찮아서 구현된 객체를 이용하는 것.