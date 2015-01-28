package my.lab.depositHelper.result;


import my.lab.depositHelper.deposit.DepositArray;
import my.lab.depositHelper.entry.deposit.Deposit;
import my.lab.depositHelper.entry.query.Query;
import my.lab.depositHelper.entry.result.Result;
import my.lab.depositHelper.query.QueryArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultsO {
    private ArrayList<Result> array = new ArrayList<>();

    public ResultsO(QueryArray queryArray, DepositArray depositArray) {

        depositArray.getArray().forEach(deposit ->
                queryArray.getArray().forEach(query -> array.add(new Result(query,deposit))) );
        
        array.sort((r1, r2) -> Double.compare(r2.getProfit(),r1.getProfit()));
    }

    public void writeFile(String path)
    {

        BufferedWriter writeFile = null;
        try {
            writeFile = new BufferedWriter(new FileWriter(path));

            writeFile.append("Specification                            Profit, RUB\n");
            for(Result writeIt: getArray()) {
                writeFile.append(writeIt.toString());
            }
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Result> getArray() {
        return array;
    }
}
