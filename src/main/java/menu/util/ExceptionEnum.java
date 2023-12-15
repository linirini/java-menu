package menu.util;

public enum ExceptionEnum {

    INVALID_NAME_LENGTH("코치 이름은 2글자 이상, 4글자 미만이어야 합니다.");

    private static final String ERROR = "[ERROR] ";
    private String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }

}
