package racingcar.constant;

public enum SymbolConstant {
    NAME(",");


    private final String symbol;

    SymbolConstant(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
