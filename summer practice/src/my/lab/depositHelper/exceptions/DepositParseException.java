package my.lab.depositHelper.exceptions;

import my.lab.depositHelper.config.R;

public class DepositParseException extends ParseException {
    public static final String DEFAULT_MSG = R.Excepts.DEPOSIT_DEFAULT_MSG;

    public DepositParseException(String message) {
        super(message);
    }

    public DepositParseException() {
        super(DEFAULT_MSG);
    }
}
