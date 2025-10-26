package racingcar.controller;

import racingcar.constant.MessageConstant;
import racingcar.model.Cars;
import racingcar.utils.Parser;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AutomobileRaceController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public AutomobileRaceController() {
        outputView.printMessage(MessageConstant.AUTOMOBILE_INPUT_MESSAGE);
    }

    public void raceStart() {
        Cars cars = createCarsFromInput();
        int count = getValidRoundCount();
        while (count <= 0) {
            cars.playRound();
            count--;
        }
    }

    private Cars createCarsFromInput() {
        String carNameInput = getCarNameInput();
        validateNameFormat(carNameInput);
        return Cars.of(carNameInput);
    }

    private int getValidRoundCount() {
        String countInput = getCountInput();
        validateCountFormat(countInput);
        return Parser.parseStringToInt(countInput);
    }

    private String getCountInput() {
        return inputView.readInput();
    }

    private String getCarNameInput() {
        return inputView.readInput();
    }

    private void validateCountFormat(String countInput) {
        InputValidator.validateInputCount(countInput);
    }

    private void validateNameFormat(String carNameInput) {
        InputValidator.validateInputIsEmpty(carNameInput);
        InputValidator.validateSeparatorInInput(carNameInput);
    }

}
