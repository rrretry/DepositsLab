package my.lab.depositHelper;

import my.lab.depositHelper.deposit.DepositArray;
import my.lab.depositHelper.query.QueryArray;
import my.lab.depositHelper.result.ResultsO;
import org.apache.log4j.Logger;

public class Run {
    public static String root = "/home/retry/Mine javampf/DepositsLab/summer practice/src/my/lab/depositHelper/";
    public static final Logger logger=Logger.getRootLogger();
    public static void main(String[] args) {
        QueryArray queryArray = new QueryArray(root + "query.txt");
        DepositArray depositArray = new DepositArray(root+"deposits.txt");

        ResultsO results = new ResultsO(queryArray, depositArray);
        results.getArray().forEach(logger::debug);
        results.writeFile(root+"Results");
    }
}


