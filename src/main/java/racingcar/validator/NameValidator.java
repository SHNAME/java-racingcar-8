package racingcar.validator;

import java.util.List;

public final class NameValidator {
    public static void validateCarLength(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("1자 이상 5글자 이하로 자동차 이름을 입력해주세요");
        }
    }


}
