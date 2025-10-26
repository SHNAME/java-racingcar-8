package racingcar.constant;

public enum SymbolConstant {
    NAME(","),
    FORWARD_COUNT("-");


    private final String symbol;

    SymbolConstant(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
