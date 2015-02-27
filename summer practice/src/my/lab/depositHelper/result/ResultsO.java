package my.lab.depositHelper.result;


import my.lab.depositHelper.Run;
import my.lab.depositHelper.config.R;
import my.lab.depositHelper.deposit.DepositArray;
import my.lab.depositHelper.entry.result.Result;
import my.lab.depositHelper.query.QueryArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ResultsO {
    public static final String OUTPUT_HEADER = R.Result.OUTPUT_HEADER;
    private ArrayList<Result> array = new ArrayList<>();

    public ResultsO(QueryArray queryArray, DepositArray depositArray) {
        
        depositArray.getArray().forEach(deposit ->
                queryArray.getArray().forEach(query -> array.add(new Result(query,deposit))) );
        array.sort(Result::compareProfit);
    }

    public void writeFile(String path)
    {

        try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(path))) {
            writeFile.append(OUTPUT_HEADER);
            for(Result writeIt: getArray()) {
                writeFile.append(writeIt.toString());
            }
            writeFile.close();
        } catch (IOException e) {
            Run.logger.error(e);
        }
    }

    public ArrayList<Result> getArray() {
        return array;
    }
}
