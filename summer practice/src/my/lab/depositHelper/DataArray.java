package my.lab.depositHelper;

import my.lab.depositHelper.entry.Entry;
import my.lab.depositHelper.exceptions.ParseException;
import java.io.*;
import java.util.ArrayList;

public abstract class DataArray<T extends Entry> {
    private ArrayList<T> array = new ArrayList<>();

    public DataArray(String path) {
        readFromFile(path);
    }


    public void readFromFile(String path){
        try (BufferedReader file = new BufferedReader(new FileReader(path))){
            for (Object s : file.lines().toArray()) {
                try {
                    getArray().add(makeEntry((String) s));
                } catch (ParseException e) {
                    Run.logger.warn(e.getMessage()+" Input: "+s);
                }
            }
            file.close();
        } catch (IOException e) {
            Run.logger.error(e.getMessage());
        }
    }

    abstract public T makeEntry(String unParsed) throws ParseException;
    //The spoon is lie...


    public ArrayList<T> getArray() {
        return array;
    }

    public T get(int index) {
        return getArray().get(index);
    }

    @Override
    public String toString() {
        return this.getArray().toString();
    }
}
