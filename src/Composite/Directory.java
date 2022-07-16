package Composite;

import DatagramClass.Datagram;
import Visitor.Visitor;

import java.util.*;

/**
 * Nodes that contain the files or a subdirectory
 */
public class Directory implements Composite {
    private final String name;
    private final List<Composite> children;
	private Composite parent;

	/**
	 * constructor of Directory
	 * @param name String with the name of the directory
	 */
    public Directory(String name) {
		this.name = name;
		children = new LinkedList<>();
		parent=null;
	}

	/**
	 * Print the name of every file in the directory
	 */
	@Override
	public void list(){
		System.out.println();
		children.forEach(Composite::list);
	}

	/**
	 * Method that accepts a visitor and performs the type of visitor to the list of datagrams of a directory
	 * @param visitor type of visitor
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Method that return the list of children
	 * @return children list
	 */
	public List<Composite> getChildren() {
		return this.children;
	}
	/**
	 * print the info inside every file in the directory
	 */
	@Override
	public void write(){
		System.out.println();
		for (Composite child:children)
			child.write();
		
	}

	/**
	 * set the parent directory to this subdirectory
	 * @param parent parent directory
	 */
	@Override
	public void setParent(Composite parent){this.parent=parent;}

	/**
	 * add a nef file or subdirectory to this directory
	 * @param child child directory or file
	 */
    public void addChild(Composite child) {
		children.add(child);
		child.setParent(this);
	}

	/**
	 * Method that search the datagrams with the name that provides the user
	 * @param name name of the datagrams to be searched
	 */
	@Override
	public List<File> lookDatagrams(String name)
	{
		LinkedList<File> lista = new LinkedList<>();
		for (Composite child:children)
			lista.addAll(child.lookDatagrams(name));
		return lista;
	}

	/**
	 * remove a selected child in a directory
	 * @param child removed
	 */
	public void removeChild(Composite child){
		children.remove(child);
		child.setParent(null);
	}

	/**
	 * Summation size of every file in a directory
	 * @return summation
	 */
	@Override
	public int size()
	{
		int fin=0;
		for (Composite child: children)
			fin=fin+child.size();
		return fin;
	}

	/**
	 * create a list of files from the directory
	 * @return list of files
	 */
	@Override
	public List<File> toList()
	{
		LinkedList<File> fin=new LinkedList<>();
		for (Composite child:children)
			fin.addAll(child.toList());
		return fin;
	}

	/**
	 * select the name of this directory
	 * @return directory's name
	 */
	@Override
	public String getName()
	{
		return this.name;
	}

}
