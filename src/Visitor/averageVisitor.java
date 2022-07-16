package Visitor;
import Composite.*;
/**
 * Type of visitor that performs the average of a label in a list of Files
 */
public class averageVisitor implements Visitor{
    String filter;
    int Average;
    int elems;

    /**
     * Constructor of the averageVisitor
     * @param filter the name of the label to be treated
     */
    public averageVisitor(String filter)
    {
        this.filter=filter;
        Average=0;
        elems=0;
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
     * Method that performs the average of the values of a specific label
     * @param trate list of Files to be treated
     */
    @Override
    public void visit(File trate) {
            for(int i =0;i<trate.size();i++){
                Average=Average+Integer.parseInt(trate.at(i,filter));
                elems++;
            }
    }

    /**
     * Get the value of the average
     * @return the average value
     */
    @Override
    public int getValue() {
        return Average/elems;
    }


}
