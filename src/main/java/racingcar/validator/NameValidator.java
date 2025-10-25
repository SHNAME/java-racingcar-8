package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public final class NameValidator {


    private static void validateCarLength(Car car) {
        if (car.getName().isEmpty() || car.getName().length() > 5) {
            throw new IllegalArgumentException("1자 이상 5글자 이하로 자동차 이름을 입력해주세요");
        }
    }

    private static void validateAlphabet(Car car) {
        if (!car.getName().matches("^[a-z|A-Z]+$")) {
            throw new IllegalArgumentException("자동차 이름은 소문자와 대문자로 구성해주세요");
        }
    }

    private static void validateNameUnique(List<Car> cars) {
        Set<String> uniqueSet = new HashSet<>();
        for (Car car : cars) {
            isUnique(car, uniqueSet);
        }
    }

    private static void isUnique(Car car, Set<String> uniqueSet) {
        if (!uniqueSet.add(car.getName())) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }


}
