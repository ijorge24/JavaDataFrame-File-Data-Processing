package mapReduce;
import java.util.*;

/**
 * Interface that apply, used in function map, and reduce, used to reduce value in a single parameter
 * @param <String> String parameter
 */
public interface IMap<String> {
	List<String> apply(List<String> elem, int rangMin, int rangMax);
     String reduce(List<String> list);
}