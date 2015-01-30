package my.lab.depositHelper.query;

import my.lab.depositHelper.DataArray;
import my.lab.depositHelper.entry.query.Query;
import my.lab.depositHelper.exceptions.ParseException;

public class QueryArray extends DataArray<Query> {


    public QueryArray(String path) {
        super(path);
    }

    @Override
    public Query makeEntry(String unParsed) throws ParseException {
        return new Query(unParsed);
    }

}

