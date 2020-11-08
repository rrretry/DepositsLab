package my.lab.depositHelper.exceptions;

import my.lab.depositHelper.config.R;

public class QueryParseException extends ParseException {

    public static final String ERROR_MSG = R.Excepts.QUERY_ERROR_MSG;

    public QueryParseException(){
        super(ERROR_MSG);
    }

    public QueryParseException(String s) {
        super(s);
    }
}
