package racingcar.model;

import racingcar.validator.NameValidator;

public class Car {
    String name;
    String count;

    private Car(String carName) {
        this.name = carName;
    }

    public static Car of(String carName) {
        Car car = new Car(carName);
        NameValidator.validateCarFormat(car);
        return car;
    }

    public String getName() {
        return name;
    }


}
