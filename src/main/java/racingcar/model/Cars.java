package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.MessageConstant;
import racingcar.utils.NumberGenerator;
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

    public void playRound() {
        for (Car car : carList) {
            attemptMove(car);
        }
        printMovementResult();
    }

    public List<Car> findWinners() {
        int maxDistance = findMaxDistance();
        return findCarByDistance(maxDistance);
    }

    private int findMaxDistance() {
        return carList.stream().mapToInt(Car::getCount)
                .max().orElse(0);
    }


    private List<Car> findCarByDistance(int maxDistance) {
        return carList.stream().filter(car -> car.getCount() == maxDistance).toList();
    }

    private void printMovementResult() {
        System.out.println(MessageConstant.EXECUTION_RESULT_MESSAGE.getMessage());
        carList.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    private void attemptMove(Car car) {
        Boolean result = car.shouldMoveForward(NumberGenerator.createRandomNumber());
        if (result) {
            car.moveForward();
        }
    }

    private static List<Car> parseStringToCarList(String input) {
        return Arrays.stream(Parser.splitInput(input)).toList().stream().map(Car::of).toList();
    }


}
