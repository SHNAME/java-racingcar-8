package racingcar.model;

import racingcar.constant.SymbolConstant;
import racingcar.validator.NameValidator;

public class Car {
    String name;
    int count;

    private Car(String carName) {
        this.name = carName;
        this.count = 0;
    }

    public static Car of(String carName) {
        Car car = new Car(carName);
        NameValidator.validateCarFormat(car);
        return car;
    }

    public String getName() {
        return name;
    }

    public Boolean shouldMoveForward(int number) {
        return number >= 4;
    }

    public void moveForward() {
        this.count++;
    }

    @Override
    public String toString() {
        return name + " : " + SymbolConstant.FORWARD_COUNT.getSymbol().repeat(count);
    }
}
