package racingcar.controller;

import java.util.List;
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
        printTotalInputMessage();
        int count = getValidRoundCount();
        printExecutionHeaderMessage();
        while (count > 0) {
            cars.playRound();
            count--;
        }
        printFinalResult(cars.findWinners());
    }

    private void printExecutionHeaderMessage() {
        System.out.println();
        outputView.printMessage(MessageConstant.EXECUTION_RESULT_MESSAGE);
    }

    private void printTotalInputMessage() {
        outputView.printMessage(MessageConstant.TOTAL_COUNT_INPUT_MESSAGE);
    }

    private void printFinalResult(List<String> winnerList) {
        outputView.printWinner(MessageConstant.WINNER_RESULT_MESSAGE, winnerList);
    }

    private Cars createCarsFromInput() {
        String carNameInput = getCarNameInput();
        validateCarNameFormat(carNameInput);
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

    private void validateCarNameFormat(String carNameInput) {
        InputValidator.validateInputIsEmpty(carNameInput);
        InputValidator.validateSeparatorInInput(carNameInput);
    }

}
