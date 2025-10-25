package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.Parser;
import racingcar.validator.NameValidator;

public class Cars {
    List<Car> carList;

    private Cars(List<Car> cars) {
        this.carList = cars;
    }

    public static Cars of(String input) {
        List<Car> cars = parseStringToCarList(input);
        NameValidator.validateCarsFormat(cars);
        return new Cars(cars);
    }

    private static List<Car> parseStringToCarList(String input) {
        return Arrays.stream(Parser.splitInput(input)).toList()
                .stream()
                .map(Car::of).toList();
    }


}
