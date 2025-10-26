package racingcar;

import racingcar.controller.AutomobileRaceController;

public class Application {
    public static void main(String[] args) {
        AutomobileRaceController automobileRaceController = new AutomobileRaceController();
        automobileRaceController.raceStart();
    }
}
