package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 총_횟수_입력_성공() {
        String testInput = "2223322";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertTrue(testInput.matches(regex));
        Assertions.assertEquals(2223322, Integer.valueOf(testInput));
    }


    @Test
    void 총_횟수_입력_실패_다른_문자_포함() {
        String testInput = "a1";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertFalse(testInput.matches(regex));
    }

    @Test
    void 총_횟수_입력_실패_0으로시작() {
        String testInput = "012";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertFalse(testInput.matches(regex));
    }


    @Test
    void 총_횟수_입력_실패_음수_입력() {
        String testInput = "-12";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertFalse(testInput.matches(regex));
    }


}
