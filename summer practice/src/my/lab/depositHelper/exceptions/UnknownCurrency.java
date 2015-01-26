package my.lab.depositHelper.exceptions;

public class UnknownCurrency extends ParseException {
    public static final String DEFAULT_MSG = "Unknown currency";

    public UnknownCurrency() {
        super(DEFAULT_MSG);
    }

}
