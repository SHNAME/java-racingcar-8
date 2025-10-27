package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.ExceptionConstant;
import racingcar.model.Car;

public final class NameValidator {
    public static void validateCarFormat(Car car) {
        validateCarLength(car);
        validateAlphabet(car);
    }

    public static void validateCarsFormat(List<Car> cars) {
        validateNameUnique(cars);
    }
    
    private static void validateCarLength(Car car) {
        if (car.getName().isEmpty() || car.getName().length() > 5) {
            throw new IllegalArgumentException(ExceptionConstant.EXCESS_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateAlphabet(Car car) {
        if (!car.getName().matches("^[a-z|A-Z]+$")) {
            throw new IllegalArgumentException(ExceptionConstant.INVALID_CAR_NAME.getMessage());
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
            throw new IllegalArgumentException(ExceptionConstant.DUPLICATE_CAR_NAME.getMessage());
        }
    }


}
