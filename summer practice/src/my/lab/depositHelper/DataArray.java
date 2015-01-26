package my.lab.depositHelper;

import my.lab.depositHelper.exceptions.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class DataArray<T> {
    private ArrayList<T> array = new ArrayList<T>();

    public DataArray(String path) throws ParseException {
        readFromFile(path);
    }


    public void readFromFile(String path) throws ParseException{
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            for (Object s : file.lines().toArray()) {
                try {
                    getArray().add(makeEntry((String) s));
                } catch (ParseException e) {
                    System.out.printf("Error input: %s\n", (String) s);
                    /*
                    //
                    // ADD LOGGER PLEASE!!!!!
                    */
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println(e);
                    /*
                    //
                    // ADD LOGGER PLEASE!!!!!
                    */
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
