package Visitor;
import Composite.*;

/**
 * Type of visitor that take the minimum value of a label in a list of Files
 */
public class minVisitor implements Visitor{
    String filter;
    int Min;

    /**
     * Constructor of the minVisitor
     * @param filter the name of the label to be treated
     */
    public minVisitor(String filter)
    {
        this.filter=filter;
        Min=0;
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
     * Method that obtains the minimum value of the values of a specific label
     * @param trate list of Files to be treated
     */
    @Override
    public void visit(File trate) {
        Min = Integer.parseInt(trate.at(0, filter));
        for(int i =0;i<trate.size();i++){
            if(Min>(Integer.parseInt(trate.at(i,filter))))
                Min=Integer.parseInt(trate.at(i,filter));
        }
    }

    /**
     * Get the value of the min
     * @return the value of the min
     */
    @Override
    public int getValue() {
        return Min;
    }
}
