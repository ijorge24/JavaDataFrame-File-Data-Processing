package Visitor;
import Composite.*;

/**
 * Type of visitor that performs the summation of a label in a list of Files
 */
public class sumVisitor implements Visitor{
    String filter;
    int Sum;

    /**
     * Constructor of the sumVisitor
     * @param filter the name of the label to be treated
     */
    public sumVisitor(String filter)
    {
        this.filter=filter;
        Sum=0;
    }
    /**
     * Method that goes through the different children of a directory applying its corresponding accept
     * @param trate directory
     */
    public void visit(Directory trate) {
        for (Composite child:trate.getChildren()) {
            child.accept(this);
        }
    }

    /**
     * Method that performs the summation of the values of a specific label
     * @param trate list of Files to be treated
     */
    @Override
    public void visit(File trate) {
            for(int i =0;i<trate.size();i++){
                Sum=Sum+Integer.parseInt(trate.at(i,filter));
            }
    }

    /**
     * Get the value of the summation
     * @return the value of the summation
     */
    @Override
    public int getValue() {
        return Sum;
    }
}
