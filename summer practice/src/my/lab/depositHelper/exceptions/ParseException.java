package my.lab.depositHelper.exceptions;

import my.lab.depositHelper.config.R;

public class ParseException extends Exception{

    public static final String DEFAULT_MSG = R.Excepts.PARSE_DEFAULT_MSG;

    public ParseException() {
        this(DEFAULT_MSG);
    }

    public ParseException(String message) {
        super(message);
    }
}
