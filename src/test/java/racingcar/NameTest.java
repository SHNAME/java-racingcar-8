package racingcar;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.validator.InputValidator;
import racingcar.validator.NameValidator;

public class NameTest {


    @Test
    void 입력_단에서_검증_성공() {
        String successInput = "car1,car2,car3";
        InputValidator.validateInputIsEmpty(successInput);
        InputValidator.validateSeparatorInInput(successInput);
    }

    @Test
    void 입력_단에서_검증_실패_빈문자열_입력() {
        String blankInput = "";
        Assertions.assertThatThrownBy(() -> InputValidator.validateInputIsEmpty(blankInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_단에서_검증_실패_잘못된_형식입력() {
        String formatErrorInput = "car1,,car2";
        Assertions.assertThatThrownBy(() -> InputValidator.validateSeparatorInInput(formatErrorInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void CAR_도메인_단에서_검증_성공() {
        String successInput = "Pobi";
        Car.of(successInput);
    }

    @Test
    void CAR_도메인_단에서_검증_실패_자동차_이름_5글자_이상() {
        String successInput = "pobiTest";
        Assertions.assertThatThrownBy(() -> Car.of(successInput)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1자 이상 5글자 이하로 자동차 이름을 입력해주세요");
    }

    @Test
    void CAR_도메인_단에서_검증_실패_자동차_이름에_숫자_포함() {
        String successInput = "Pobi3";
        Assertions.assertThatThrownBy(() -> Car.of(successInput)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 소문자와 대문자로 구성해주세요");
    }

    @Test
    void CARS_단에서_검증_성공() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of("pobi"));
        cars.add(Car.of("ted"));
        cars.add(Car.of("jyp"));
        NameValidator.validateCarsFormat(cars);
    }

    @Test
    void CARS_단에서_검증_실패_중복된_이름_포함() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of("pobi"));
        cars.add(Car.of("pobi"));
        cars.add(Car.of("jyp"));
        Assertions.assertThatThrownBy(() -> NameValidator.validateCarsFormat(cars))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 중복될 수 없습니다.");
    }


}
