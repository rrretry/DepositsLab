package my.lab.depositHelper;

import my.lab.depositHelper.deposit.DepositArray;
import my.lab.depositHelper.entry.result.Result;
import my.lab.depositHelper.query.QueryArray;
import my.lab.depositHelper.result.ResultsO;

import javax.swing.*;
import java.awt.*;

public class Run {

    public static void main(String[] args) throws Exception {

        QueryArray queryArray = new QueryArray("/home/retry/Mine javampf/DepositsLab/summer practice/src/my/lab/depositHelper/query.txt");
        DepositArray depositArray = new DepositArray("/home/retry/Mine javampf/DepositsLab/summer practice/src/my/lab/depositHelper/deposits.txt");

        ResultsO results = new ResultsO(queryArray, depositArray);

        for (Result result: results.getArray())
            System.out.println(result);

        results.writeFile("/home/retry/Mine javampf/DepositsLab/summer practice/src/my/lab/depositHelper/Results");
    }
}


