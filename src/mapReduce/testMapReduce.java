package mapReduce;

import Factory.*;

import Composite.*;


/**
 * Testing the MapReduce applications
 */
public class testMapReduce {
    public static void main(String[] args) {
        System.out.println("Test MapReduce and Composite");
        System.out.println("Creating global directory...");
        Directory dir_datagram= new Directory("Directory of dataframes");
        System.out.println("Dir_datagram created");

        System.out.println("Creating csv and txt directory...");
        Directory dir_txt=new Directory("TXT directory");
        Directory dir_csv=new Directory("CSV directory");
        Directory dir_cities_csv=new Directory("cities directory CSV");
        Directory dir_cities_txt=new Directory("cities directory txt");
        System.out.println("Directories created...");

        System.out.println("Creating csv and txt files...");
        File csv=new File(new CSV().readFile("cities.csv"));
        File csv2=new File(new CSV().readFile("cities2.csv"));
        File txt=new File(new TXT().readFile("cities3.txt"));
        System.out.println("Files created...");

        System.out.println("Adding csv and txt files...");
        dir_datagram.addChild(dir_txt);
        dir_datagram.addChild(dir_csv);
        dir_csv.addChild(dir_cities_csv);
        dir_txt.addChild(dir_cities_txt);
        dir_cities_csv.addChild(csv);
        dir_cities_csv.addChild(csv2);
        dir_cities_txt.addChild(txt);
        System.out.println("Csv and txt files added");

         System.out.println("Testing class mapReduce");
        mapReduce mapa=new mapReduce();
        System.out.println("Testing function sumFilter from global directory with values from 0 to 100");
        System.out.println(mapa.mapRed(dir_datagram, "LonD", new sumFilter(), 0, 100));
        System.out.println("Testing function sumFilter from CSV subdirectory with values from 0 to 100");
        System.out.println(mapa.mapRed(dir_csv, "LonD", new sumFilter(), 98, 100));
        System.out.println("Testing function joinCase from global directory");
        System.out.println(mapa.mapRed(dir_datagram, "City", new joinCase(), 0, 0));
        System.out.println("Testing function joinCase from TXT subdirectory");
        System.out.println(mapa.mapRed(dir_txt, "City", new joinCase(), 0, 0));
    }
}
