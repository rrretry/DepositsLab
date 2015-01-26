package my.lab.depositHelper.entry.deposit;

import my.lab.depositHelper.entry.Entry;
import my.lab.depositHelper.exceptions.DepositParseException;
import my.lab.depositHelper.exceptions.ParseException;

public class Deposit extends Entry {
    public static final int NUM_OF_ARGS=3;

    private String bank;
    private double percentage;

    public Deposit(String unParsed) throws ParseException {
        super(unParsed);
    }


    @Override
    public void initEntry(String[] parsed) throws ParseException {
        try {
            if(parsed.length==NUM_OF_ARGS) {
                setBank(parsed[0]);
                setCurrency(parsed[1]);
                setPercentage(parsed[2]);
            }else
                throw new DepositParseException();

        }catch (NumberFormatException e) {
            throw new DepositParseException(e.toString());
        }
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = Double.valueOf(percentage.substring(0, percentage.length()-1));
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%%", getBank(), String.valueOf(getCurrency()), getPercentage());
    }
}
