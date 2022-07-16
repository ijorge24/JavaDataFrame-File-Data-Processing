package mapReduce;

import java.util.List;
import java.util.stream.Collectors;

/**
 * execute the joinCase applying MapReduce
 */
public class joinCase implements IMap<String> {
    /**
     * Transform a list of String in capital letters
     * @param elem list of Strings that we want in capital letters
     * @param rangMin without use
     * @param rangMax without use
     * @return list transformed
     */
    @Override
	public List<String> apply(List<String> elem, int rangMin, int rangMax) {

        return elem.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

    /**
     * collect in a single String all the text in the list
     * @param list every String we want in a single String
     * @return reduced String
     */
    @Override
    public String reduce(List<String> list) {
        return list.stream().reduce("", (partialString, element) -> partialString + element + ", ");
    }
    
}
