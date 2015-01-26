package my.lab.depositHelper.exceptions;

public class ParseException extends Exception{

    public static final String DEFAULT_MSG = "Parse error";

    public ParseException() {
        this(DEFAULT_MSG);
    }

    public ParseException(String message) {
        super(message);
    }
}
