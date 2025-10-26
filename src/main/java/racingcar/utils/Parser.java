package racingcar.utils;

import racingcar.constant.SymbolConstant;

public final class Parser {
    public static String[] splitInput(String userInput) {
        return userInput.split(SymbolConstant.NAME.getSymbol());
    }

    public static int parseStringToInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

}
