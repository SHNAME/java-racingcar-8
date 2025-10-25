package racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class NameTest {
    private final String SUCCESS_INPUT = "car1,car2,car3";
    private final String FAIL_INPUT_FORMAT_ERROR = "car1,,car2";
    private final String FAIL_INPUT_BLANK_ERROR = "";


    @Test
    void 입력_단에서_검증_성공() {
        InputValidator.validateInputIsEmpty(SUCCESS_INPUT);
        InputValidator.validateSeparatorInInput(SUCCESS_INPUT);
    }

    @Test
    void 입력_단에서_검증_실패_빈문자열_입력() {
        Assertions.assertThatThrownBy(() -> InputValidator.validateInputIsEmpty(FAIL_INPUT_BLANK_ERROR))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_단에서_검증_실패_잘못된_형식입력() {
        Assertions.assertThatThrownBy(() -> InputValidator.validateSeparatorInInput(FAIL_INPUT_FORMAT_ERROR))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
