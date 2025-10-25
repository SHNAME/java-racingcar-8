package racingcar.validator;

import java.util.List;

public final class NameValidator {
    public static void validateCarLength(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    public static void validateAlphabet(List<String> names) {
        for (String name : names) {
            isAlphabet(name);
        }
    }

    private static void isAlphabet(String name) {
        if (!name.matches("^[a-z|A-Z]+$")) {
            throw new IllegalArgumentException("자동차 이름은 소문자와 대문자로 구성해주세요");
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("1자 이상 5글자 이하로 자동차 이름을 입력해주세요");
        }
    }


}
