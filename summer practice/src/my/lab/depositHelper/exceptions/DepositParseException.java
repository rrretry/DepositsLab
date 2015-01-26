package my.lab.depositHelper.exceptions;

public class DepositParseException extends ParseException {
    public static final String DEFAULT_MSG = "Deposit parse error";

    public DepositParseException(String message) {
        super(message);
    }

    public DepositParseException() {
        super(DEFAULT_MSG);
    }
}
