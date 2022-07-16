package mapReduce;
import java.util.*;
import Composite.*;

/**
 * Class to implement mapReduce
 */
public class mapReduce {
    /**
     * applies a task to all the elements of a list
     * @param list     info selected
     * @param function  instructions applied on every element
     * @param rangMin  down rang
     * @param rangMax  upper rang
     * @param <T>      generic parameter
     * @return the list with changes applied
     */
    public static <T> List<T> map(List<T> list, IMap<T> function, int rangMin, int rangMax) {
        List<T> result;
            result=function.apply(list,  rangMin, rangMax);
        return result;
    }

    /**
     *  collect in a single String values reduced
     * @param list  list of parameter
     * @param function  instructions to reduce every element
     * @param <T> generic parameter
     * @return a single value reduced
     */
    public static <T> String reduce(List<T> list, IMap<T> function){
        if( list.isEmpty())
            return"there are no values to treat that satisfies the requirements";
        else
            return function.reduce(list).toString();
    }
    /**
     * applies a task to all the elements of a list and then summarizes the list in a single output parameter
     * @param function directory or File with datagrams
     * @param label info to select
     * @param functionMap instructions applied on every element
     * @param rangMin  down rang
     * @param rangMax upper rang
     * @return a single value with the mapReduce applied
     */
    public  String mapRed(Composite function, String label, IMap<String> functionMap, int rangMin, int rangMax){
		List<File> result = function.toList();
		List<String> total = new ArrayList<>();
        for (File child:result)
        {
            total.addAll(child.getInfo().get(label));
        }
		total=map(total, functionMap, rangMin, rangMax);
		return reduce(total, functionMap);
    }
}
