package my.lab.depositHelper.entry.result;

import my.lab.depositHelper.config.R;
import my.lab.depositHelper.entry.deposit.Deposit;
import my.lab.depositHelper.entry.query.Query;

public class Result {
    public static final int BETWEEN_COLUMNS = R.Result.BETWEEN_COLUMNS;
    static StringBuilder spaces;
    private String identification;
    private double profit;
    private double amount;

    public Result(Query query, Deposit deposit) {
        setIdentification(String.format("%s:%s using %.2f of %s",
                deposit.getBank(), deposit.getCurrency(), query.getAmount(), query.getCurrency()));
        setAmount(query, deposit);
        calcProfit(query, deposit);
    }

    private void setAmount(Query query, Deposit deposit) {

        switch (deposit.getCurrency()) {
            case RUB:
                setAmount(query.getAmount());
                break;
            case USD:
                setAmount(toUSD(query));
                break;
            case EUR:
                setAmount(toEUR(query));
                break;
            //default:
                //throw new UnknownCurrency();
        }
    }//WTF IS IT!!!!??? KILL ME PLEASE...

    private double toUSD(Query query) {
        return convertToRUB(query)*query.getCurrentDollar();
    }


    private double toEUR(Query query) {
        return convertToRUB(query)*query.getCurrentEuro();
    }

    private double convertToRUB(Query query) {
        switch (query.getCurrency()) {
            case USD:
                return query.getAmount()*query.getCurrentDollar();
            case EUR:
                return query.getAmount()*query.getCurrentEuro();
            default:
                return query.getAmount();
        }
    }

    private void calcProfit(Query query, Deposit deposit) {
        double compoundInterest;
        compoundInterest = getAmount() * Math.pow((1 + deposit.getPercentage() / 100d), query.getYear());
        setProfit( compoundInterest - getAmount() );
    }


    @Override
    public String toString() {
        spaces=new StringBuilder();
        for (int i = BETWEEN_COLUMNS; i > getIdentification().length(); i--) {
            spaces.append(" ");
        }
        return String.format("%s %f\n", getIdentification()+spaces.toString(), getProfit());
    }

    public double getAmount() {
        return amount;
    }

    /**
     * @param amount amount in RUB
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public int compareProfit(Result other) {
        return Double.compare(other.getProfit(), this.getProfit());
    }


}
