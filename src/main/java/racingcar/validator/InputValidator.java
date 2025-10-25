package racingcar.validator;

import racingcar.utils.Parser;

public final class InputValidator {

    public static void validateInputIsEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException("빈 문자열을 입력했습니다. 다시 입력해 주세요");
        }
    }

    public static void validateSeparatorInInput(String userInput) {
        String[] names = Parser.splitInput(userInput);
        for (String name : names) {
            checkNameIsNotBlank(name);
        }
    }

    private static void checkNameIsNotBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("입력값에서 쉼표로 구분된 각 항목은 유효한 자동차 이름이어야 합니다.");
        }
    }


}
