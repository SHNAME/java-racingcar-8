package racingcar.model;

public class Car {
    String name;
    String count;

    private Car(String carName) {
        this.name = carName;
    }

    public static Car of(String carName) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }


}
