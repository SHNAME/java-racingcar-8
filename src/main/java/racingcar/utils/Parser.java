package racingcar.utils;

import racingcar.constant.SymbolConstant;

public final class Parser {
    public static String[] splitInput(String userInput) {
        return userInput.split(SymbolConstant.NAME.getSymbol());
    }

}
