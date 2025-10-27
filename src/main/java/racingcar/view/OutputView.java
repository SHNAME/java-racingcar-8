package racingcar.view;

import java.util.List;
import racingcar.constant.MessageConstant;
import racingcar.constant.SymbolConstant;

public class OutputView {

    public void printMessage(MessageConstant message) {
        System.out.println(message.getMessage());
    }

    public void printWinner(MessageConstant message, List<String> winnerList) {
        String winnerName = String.join(SymbolConstant.NAME.getSymbol() + " ", winnerList);
        System.out.println(message.getMessage() + " : " + winnerName);
    }

}
