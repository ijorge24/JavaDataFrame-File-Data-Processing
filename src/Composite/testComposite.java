package Composite;
import Factory.*;
import Visitor.*;
import java.util.List;

public class testComposite {
    public static void main(String[] args) {
        System.out.println("Test composite and visitor");
        System.out.println("Creating global directory...");
        Directory dir_datagram= new Directory("Directory of dataframes");
        System.out.println("Dir_datagram created");
        System.out.println("Creating csv and txt directory...");
        Directory dir_csv=new Directory("CSV directory");
        Directory dir_txt=new Directory("TXT directory");
        System.out.println("Directories created...");
        System.out.println("Adding csv and txt files...");
        dir_datagram.addChild(dir_csv);
        dir_datagram.addChild(dir_txt);
        File csv=new File(new CSV().readFile("cities.csv"));
        dir_csv.addChild(csv);
        File csv2=new File(new CSV().readFile("cities2.csv"));
        dir_csv.addChild(csv2);
        File txt=new File(new TXT().readFile("cities3.txt"));
        dir_txt.addChild(txt);
        System.out.println("Csv and txt files added");
        System.out.println("Listing the different files of the global directory");
        dir_datagram.list();
        System.out.println("Testing function size in global datagram directory");
        System.out.println(dir_datagram.size());
        System.out.println("Removing a csv child and make again size");
        dir_csv.removeChild(csv);
        dir_datagram.list();
        System.out.println(dir_datagram.size());
        System.out.println("Writing the content of the datagrams in csv directory...");
        dir_csv.addChild(csv);
        dir_csv.write();
        System.out.println("Look for the datagram cities in all the directories");
        List<File> list;
        list=dir_datagram.lookDatagrams("cities");
        if (list.isEmpty())
            System.out.println("Error, not found");
        else
            System.out.println("Great, found!");
        System.out.println("Test of visitor!!!");
        System.out.println("Getting the average of all the values of the column LonD");
        Visitor visit =new averageVisitor("LonD");
        dir_datagram.accept(visit);
        System.out.println("The average is "+visit.getValue());
        System.out.println("Getting the maximum of all the values of the column LonD");
        visit =new maxVisitor("LonD");
        dir_datagram.accept(visit);
        System.out.println("The maximum is "+visit.getValue());
        System.out.println("Getting the minimum of all the values of the column LonD");
        visit =new minVisitor("LonD");
        dir_datagram.accept(visit);
        System.out.println("The minimum is "+visit.getValue());
        System.out.println("Getting the summation of all the values of the column LonD");
        visit =new sumVisitor("LonD");
        dir_datagram.accept(visit);
        System.out.println("The summation is "+visit.getValue());
        System.out.println("Test Composite and Visitor finished!!!");
    }
}
