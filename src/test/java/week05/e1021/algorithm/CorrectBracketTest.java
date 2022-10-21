package week05.e1021.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectBracketTest {

    @Test
    @DisplayName("올바른 괄호 테스트 통과")
    void bracket() {
        CorrectBracket correctBracket = new CorrectBracket();

        assertTrue(correctBracket.solution("()()"));
        assertTrue(correctBracket.solution("(())()"));
        assertFalse(correctBracket.solution(")()("));
        assertFalse(correctBracket.solution("(()("));
        assertFalse(correctBracket.solution( ("((((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))")));
    }
}
