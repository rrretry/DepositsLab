package my.lab.depositHelper.result;


import my.lab.depositHelper.deposit.DepositArray;
import my.lab.depositHelper.entry.deposit.Deposit;
import my.lab.depositHelper.entry.query.Query;
import my.lab.depositHelper.entry.result.Result;
import my.lab.depositHelper.query.QueryArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class ResultsO {
    private ArrayList<Result> array = new ArrayList<Result>();

    public ResultsO(QueryArray queryArray, DepositArray depositArray) {
        for(Deposit deposit: depositArray.getArray()) {
            for(Query query: queryArray.getArray()) {
                array.add(new Result(query, deposit));
            }
        }
        array.sort(new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if( (o1.getProfit() - o2.getProfit()) >= 0) {
                    if (o1.getProfit() == o2.getProfit()) {
                        return 0;
                    }
                    return -1;
                }else
                    return 1;
            }

        });
    }

    public void writeFile(String path)
    {

        BufferedWriter writeFile = null;
        try {
            writeFile = new BufferedWriter(new FileWriter(path));

            writeFile.append("Specification                            Profit, RUB\n");
            for(Result writeIt: getArray()) {
                writeFile.append(writeIt.toString()+"\n");
            }
            writeFile.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writeFile != null) {
                try {
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Result> getArray() {
        return array;
    }
}
