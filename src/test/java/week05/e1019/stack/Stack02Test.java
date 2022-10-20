package week05.e1019.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Stack02Test {

    @BeforeEach
    void setUp() {
        // @BeforeEach: 각 테스트가 실행되기 전에 실행되는 구간
        // 각 테스트는 독립적으로 실행되어야 한다.
        // ex) DB 에서 데이터 지우는 코드
        // ex) DB 에서 데이터를 넣는 코드
        System.out.println("before each");
    }

    @Test
    @DisplayName("push 가 잘 되는지")
    void push() {
        Stack02 stack02 = new Stack02();
        stack02.push(10);
        stack02.push(20);
        Integer[] arr = stack02.getArr();
        assertEquals(20, arr[1]);
        assertEquals(10, arr[0]);

    }

    @Test
    @DisplayName("pushAndPop이 잘 되는지")
    void pushAndPop() {
        Stack02 stack02 = new Stack02();
        stack02.push(10);
        stack02.push(20);

        assertEquals(20, stack02.pop());
        assertEquals(10, stack02.pop());
        // st.pop() 비어있으면?
    }
}