package Visitor;
import Composite.*;


/**
 * Type of visitor that take the maximum value of a label in a list of Files
 */
public class maxVisitor implements Visitor{
    String filter;
    int Max;

    /**
     * Constructor of the maxVisitor
     * @param filter the name of the label to be treated
     */
    public maxVisitor(String filter)
    {
        this.filter=filter;
        Max=0;
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
     * Method that obtains the maximum value of the values of a specific label
     * @param trate list of Files to be treated
     */
    @Override
    public void visit(File trate) {
            for(int i =0;i<trate.size();i++){
               if(Max<(Integer.parseInt(trate.at(i,filter))))
                Max=Integer.parseInt(trate.at(i,filter));
            }

    }

    /**
     * Get the value of the max
     * @return the value of the max
     */
    @Override
    public int getValue() {
        return Max;
    }
}
