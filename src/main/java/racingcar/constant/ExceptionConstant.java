package racingcar.constant;

public enum ExceptionConstant {

    EMPTY_INPUT_ERROR("빈 문자열을 입력했습니다. 다시 입력해 주세요"),
    INVALID_INPUT_FORMAT("입력값에서 쉼표로 구분된 각 항목은 유효한 자동차 이름이어야 합니다."),
    EXCESS_CAR_NAME_LENGTH("1자 이상 5글자 이하로 자동차 이름을 입력해주세요"),
    INVALID_CAR_NAME("자동차 이름은 소문자와 대문자로 구성해주세요"),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
