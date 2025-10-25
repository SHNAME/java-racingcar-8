package racingcar.validator;

public final class InputValidator {

    public static void validateInputIsEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException("빈 문자열을 입력했습니다. 다시 입력해 주세요");
        }
    }
}
