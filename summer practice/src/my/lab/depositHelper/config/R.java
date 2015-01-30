package my.lab.depositHelper.config;

public class R {
    public class Query {
        public static final int NUM_OF_ARGS=7;

    }
    public class Entry {
        public static final String DEFAULT_SPLIT = ",|[ \f\n\n\t]+";
    }
    public class Result {
        public static final int BETWEEN_COLUMNS = 40;
    }

    public class Excepts {
        public static final String PARSE_DEFAULT_MSG = "Parse error";
        public static final String DEPOSIT_DEFAULT_MSG = "Deposit parse error";
        public static final String QUERY_ERROR_MSG = "Query parse error";
    }
}
