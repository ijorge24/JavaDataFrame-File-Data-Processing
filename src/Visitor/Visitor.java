package Visitor;
import Composite.*;
/**
 * Interface that allows us to define a new operation without introducing the modifications to an existing object structure
 */
public interface Visitor {
    void visit (Directory trate);
    void visit (File trate);
    int getValue();
}
