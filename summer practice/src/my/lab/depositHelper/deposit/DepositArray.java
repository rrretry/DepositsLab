package my.lab.depositHelper.deposit;

import my.lab.depositHelper.DataArray;
import my.lab.depositHelper.entry.deposit.Deposit;
import my.lab.depositHelper.exceptions.DepositParseException;
import my.lab.depositHelper.exceptions.ParseException;

import java.io.*;

public class DepositArray extends DataArray<Deposit> {

    public DepositArray(String path) throws ParseException {
        super(path);
    }

    @Override
    public Deposit makeEntry(String unParsed) throws ParseException {
        return new Deposit(unParsed);
    }
}
