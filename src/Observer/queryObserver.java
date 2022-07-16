package Observer;

import DatagramClass.Datagram;

import java.util.*;
import java.util.function.Predicate;

    /**
     * Type of datagramObserver that only catch query instructions
     */
public class queryObserver extends Datagram  implements datagramObserver{
    List<String> datalist;

        /**
         * Constructor of queryObserver
         * @param data datagram with the info
         */
    public queryObserver(Datagram data)
    {
        super(data);
        datalist=new ArrayList<>();
    }

    /**
     * Method that writes the functions consulted. In this case only will print the query type
     */
    @Override
    public void listFunctions() {
        System.out.println("List of functions of QueryObserver:");
        for (String str:datalist)
           System.out.println(str);
    }

    /**
     * Query method invoked by proxy
     * @param col column label name
     * @param selec condition applied to filter
     * @return the result of query instruction
     */
    @Override
    public ArrayList<String> query(String col, Predicate<String> selec) {
        datalist.add("query");
        return super.query(col, selec);
    }
}
