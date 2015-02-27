package my.lab.depositHelper.config;

public class R {
    public class Query {
        public static final int NUM_OF_ARGS=7;

    }
    public class Entry {
        public static final String DEFAULT_SPLIT = ",|[ \f\n\n\t]+";
    }
    public class Result {
        public static final String ID_FORMAT = "%s:%s using %.2f of %s";
        public static final String FORMAT = "%-40s %f\n";
        public static final String OUTPUT_HEADER = "Specification                            Profit, RUB\n";
    }

    public class Excepts {
        public static final String PARSE_DEFAULT_MSG = "Parse error";
        public static final String DEPOSIT_DEFAULT_MSG = "Deposit parse error";
        public static final String QUERY_ERROR_MSG = "Query parse error";
    }
}
