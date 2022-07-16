package Observer;
import java.util.*;
import java.util.function.Predicate;

/**
 * interface with the datagram functions of Observer pattern
 */
public interface datagramObserver  {
    void listFunctions();
    String at(int row, String col);
    String iat(int row, int col);
    ArrayList<String> sort(String col,Comparator<String> comp);
    ArrayList<String> query(String col, Predicate<String> selec);
}
