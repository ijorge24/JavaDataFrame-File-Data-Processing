package Observer;

import DatagramClass.Datagram;
import java.util.*;
import java.util.function.Predicate;

    /**
     * catch instructions at, iat, sort, query and size in a List with all instructions
     */
public class logObserver extends Datagram implements datagramObserver{
    List<String> datalist;

    /**
     * logObserver constructor
     * @param data datagram to observed
     */
    public logObserver(Datagram data)
    {
        super(data);
        datalist=new ArrayList<>();
    }

    /**
     * print every Function in the list
     */
    @Override
    public void listFunctions() {
        System.out.println("List of functions of LogObserver:");
        for (String str:datalist)
            System.out.println(str);
    }

    /**
     * call to at instruction in datagram class
     * @param row number with the row selected
     * @param col column label name
     * @return result of at instruction
     */
    @Override
    public String at(int row, String col) {
        datalist.add("at");
        return super.at(row, col);
    }

    /**
     * call to iat instruction in datagram class
     * @param row number with the row selected
     * @param col number with the column selected
     * @return result of iat instruction
     */
    @Override
    public String iat(int row, int col) {
        datalist.add("iat");
        return super.iat(row, col);
    }

    /**
     * call to sort instruction in datagram class
     * @param col  column label name
     * @param comp comparator instruction applied to the list
     * @return result of sort instruction
     */
    @Override
    public ArrayList<String> sort(String col, Comparator<String> comp) {
        datalist.add("sort");
        return super.sort(col, comp);
    }

    /**
     * call to query instruction in datagram class
     * @param col column label name
     * @param selec condition applied to filter
     * @return result of query instruction
     */
    @Override
    public ArrayList<String> query(String col, Predicate<String> selec) {
        datalist.add("query");
        return super.query(col, selec);
    }

    /**
     * call to size instruction in datagram class
     * @return result of size instruction
     */
    @Override
    public int size() {
        datalist.add("size");
        return super.size();
    }
}
