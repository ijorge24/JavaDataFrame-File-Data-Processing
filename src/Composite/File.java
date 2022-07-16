package Composite;

import DatagramClass.Datagram;
import Visitor.Visitor;
import java.util.LinkedList;
import java.util.List;

/**
 * leaves from the directories nodes with datagram info
 */
public class File extends Datagram implements Composite {
    private Composite parent;

    /**
     * constructor file
     * @param data datagram info
     */
    public File(Datagram data){
    super(data);
    parent=null;
    }

    /**
     * Method that accepts a visitor and performs the type of visitor to the datagram associated to the file
     * @param visitor type of visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * print the name of this file
     */
    @Override
    public void list()
    {
        System.out.println(getName());
    }

    /**
     * call size function of datagram class
     * @return datagram size
     */
    @Override
    public int size(){return super.size();}

    /**
	 * select the name of this file
	 * @return file's name
	 */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
	 * print the info inside the file
	 */
    @Override
    public void write() {
        super.Write();
    }

    /**
     * method that add the file if it has the same name as the one we are looking for
     * @param name file's name
     */
    @Override
    public List<File> lookDatagrams(String name) {
        LinkedList<File> lista = new LinkedList<>();
        if(getName().equals(name)) {
            lista.add(this);
        }
        return lista;
    }

    /**
     * Insert a file to the list
     * @return the list with the file added
     */
    @Override
    public List<File> toList() {
        LinkedList<File> fin=new LinkedList<>();
        fin.add(this);
        return fin;
    }

    /**
	 * set the parent directory to this file
	 * @param parent parent directory
	 */
    @Override
    public void setParent(Composite parent)  {
        this.parent=parent;
    }
}
