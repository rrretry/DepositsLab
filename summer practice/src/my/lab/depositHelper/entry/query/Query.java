package my.lab.depositHelper.entry.query;

import my.lab.depositHelper.entry.Entry;
import my.lab.depositHelper.exceptions.ParseException;
import my.lab.depositHelper.exceptions.QueryParseException;

public class Query extends Entry {
    public static final int NUM_OF_ARGS=7;

    private double amount;
    private double year;
    private double currentDollar;
    private double expectedDollar;
    private double currentEuro;
    private double expectedEuro;

    public Query(String unParsed) throws ParseException {
        super(unParsed);
    }

    @Override
    public void initEntry(String[] parsed) throws ParseException {
        try {
            if(parsed.length==NUM_OF_ARGS) {
                setCurrency(parsed[0]);
                setAmount(parsed[1]);
                setYear(parsed[2]);
                setCurrentDollar(parsed[3]);
                setExpectedDollar(parsed[4]);
                setCurrentEuro(parsed[5]);
                setExpectedEuro(parsed[6]);
            }else
                throw new QueryParseException();

        }catch (NumberFormatException e) {
            throw new QueryParseException(e.toString());
        }
    }

    public double getAmount() {
        return amount;
    }
//    public double getAmountEUR() {}

    public void setAmount(String amount) {
        this.amount = Double.parseDouble(amount);
    }

    public double getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = Double.parseDouble(year);
    }

    public double getCurrentDollar() {
        return currentDollar;
    }

    public void setCurrentDollar(String currentDollar) {
        this.currentDollar = Double.parseDouble(currentDollar);
    }

    public double getExpectedDollar() {
        return expectedDollar;
    }

    public void setExpectedDollar(String expectedDollar) {
        this.expectedDollar = Double.parseDouble(expectedDollar);
    }

    public double getCurrentEuro() {
        return currentEuro;
    }

    public void setCurrentEuro(String currentEuro) {
        this.currentEuro = Double.parseDouble(currentEuro);
    }

    public double getExpectedEuro() {
        return expectedEuro;
    }

    public void setExpectedEuro(String expectedEuro) {
        this.expectedEuro = Double.parseDouble(expectedEuro);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.4f %.4f %.4f %.4f %.4f", String.valueOf(getCurrency()), getAmount(), getYear(),
                getCurrentDollar(), getExpectedDollar(), getCurrentEuro(), getExpectedEuro());
    }
}
