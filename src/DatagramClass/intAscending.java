package DatagramClass;

import java.util.*;

/** 
 * applied in sort function
 */
public class intAscending  implements Comparator<String> {
	/**
	 * compare 2 Strings like Integer values
	 * @param s1 first value
	 * @param s2 second value
	 * @return 1 if the s1 is higher than s2, 0 if are equals, or -1 if s1 is lower than s2, it's applied to order a number of lists
	 */
	public int compare(String s1,String s2) {

		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);

		if (i1 > i2)
			return 1;
		else if (i1 < i2)
			return -1;
		else
			return 0;
	}

}
