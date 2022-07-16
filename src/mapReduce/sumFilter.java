package mapReduce;

import java.util.List;
import java.util.stream.Collectors;


/**
 * execute the add of the values applying MapReduce
 */
public class sumFilter implements IMap<String> {
    /**
     * select the value tha are into these parameters
     * @param elem  list to filter the info
     * @param rangMin down rang
     * @param rangMax upper rang
     * @return item list that are into parameters
     */
	public List<String> apply(List<String> elem, int rangMin, int rangMax) {
        return  elem.stream().filter((a)->Integer.parseInt(a)>rangMin&&Integer.parseInt(a)<rangMax).collect(Collectors.toList());
	}


    /**
     * collect in a single String the sum of all values
     * @param list every String we want add
     * @return reduced String with correct number
     */
    @Override
    public String reduce(List<String> list) {
        return list.stream().reduce((a, b) -> String.valueOf(Integer.parseInt(a) + Integer.parseInt(b))).toString();
    }
}    
