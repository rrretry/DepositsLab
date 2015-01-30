package my.lab.depositHelper;

import my.lab.depositHelper.deposit.DepositArray;
import my.lab.depositHelper.query.QueryArray;
import my.lab.depositHelper.result.ResultsO;


public class Run {

    public static void main(String[] args) {
        QueryArray queryArray = new QueryArray("/home/retry/Mine javampf/DepositsLab/summer practice/src/my/lab/depositHelper/query.txt");
        DepositArray depositArray = new DepositArray("/home/retry/Mine javampf/DepositsLab/summer practice/src/my/lab/depositHelper/deposits.txt");

        ResultsO results = new ResultsO(queryArray, depositArray);

        results.getArray().forEach(System.out::print);

        results.writeFile("/home/retry/Mine javampf/DepositsLab/summer practice/src/my/lab/depositHelper/Results");
    }
}


