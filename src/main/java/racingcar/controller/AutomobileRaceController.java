package racingcar.controller;

import racingcar.constant.MessageConstant;
import racingcar.view.OutputView;

public class AutomobileRaceController {
    private OutputView outputView = new OutputView();

    public AutomobileRaceController() {
        outputView.printMessage(MessageConstant.AUTOMOBILE_INPUT_MESSAGE);
    }

}
