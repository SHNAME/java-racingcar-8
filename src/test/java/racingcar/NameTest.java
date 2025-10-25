package racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class NameTest {


    @Test
    void 입력_단에서_검증_성공() {
        String successInput = "car1,car2,car3";
        InputValidator.validateInputIsEmpty(successInput);
        InputValidator.validateSeparatorInInput(successInput);
    }

    @Test
    void 입력_단에서_검증_실패_빈문자열_입력() {
        String blankInput = "";
        Assertions.assertThatThrownBy(() -> InputValidator.validateInputIsEmpty(blankInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_단에서_검증_실패_잘못된_형식입력() {
        String formatErrorInput = "car1,,car2";
        Assertions.assertThatThrownBy(() -> InputValidator.validateSeparatorInInput(formatErrorInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
