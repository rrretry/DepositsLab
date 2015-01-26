package my.lab.depositHelper.exceptions;

public class QueryParseException extends ParseException {

    public static final String ERROR_MSG = "Query parse error";

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public QueryParseException(){
        super(ERROR_MSG);
    }

    public QueryParseException(String s) {
        super(s);
    }
}
