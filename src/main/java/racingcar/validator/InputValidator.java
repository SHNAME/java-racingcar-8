package racingcar.validator;

import racingcar.constant.ExceptionConstant;
import racingcar.utils.Parser;

public final class InputValidator {

    public static void validateInputIsEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(ExceptionConstant.EMPTY_INPUT_ERROR.getMessage());
        }
    }

    public static void validateSeparatorInInput(String userInput) {
        String[] names = Parser.splitInput(userInput);
        for (String name : names) {
            checkNameIsNotBlank(name);
        }
    }

    public static void validateInputCount(String userInput) {
        if (!userInput.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException(ExceptionConstant.INVALID_COUNT_FORMAT.getMessage());
        }
    }


    private static void checkNameIsNotBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ExceptionConstant.INVALID_INPUT_FORMAT.getMessage());
        }
    }


}
