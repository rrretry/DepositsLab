package my.lab.depositHelper.entry;

import my.lab.depositHelper.Currency;
import my.lab.depositHelper.config.R;
import my.lab.depositHelper.exceptions.ParseException;

abstract public class Entry {
    public static final String DEFAULT_SPLIT = R.Entry.DEFAULT_SPLIT;
    private Currency currency;
    static String REGEX_SPLIT;

    //public        final int             NUM_OF_ARGS;

    public Entry(String unParsed) throws ParseException {
        if (REGEX_SPLIT == null) {
            setRegexSplit(DEFAULT_SPLIT);
        }
        initEntry(unParsed.split(REGEX_SPLIT));
    }
    public Entry(String unParsed, String split) throws ParseException {
        if (REGEX_SPLIT == null) {
            setRegexSplit(split);
        }
        initEntry(unParsed.split(REGEX_SPLIT));
    }

    public void setRegexSplit(String regexSplit) {
        REGEX_SPLIT=regexSplit;
    }

    abstract public void initEntry(String[] parsed) throws ParseException;


    @Override
    abstract public String toString();

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = Currency.valueOf(currency);
    }
}
