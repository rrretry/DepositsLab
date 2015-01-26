package my.lab.depositHelper.query;

import com.sun.istack.internal.NotNull;
import my.lab.depositHelper.DataArray;
import my.lab.depositHelper.entry.Entry;
import my.lab.depositHelper.entry.query.Query;
import my.lab.depositHelper.exceptions.ParseException;
import my.lab.depositHelper.exceptions.QueryParseException;

import java.io.Serializable;

public class QueryArray extends DataArray<Query> {


    public QueryArray(String path) throws ParseException {
        super(path);
    }

    @Override
    public Query makeEntry(String unParsed) throws ParseException {
        return new Query(unParsed);
    }

}

