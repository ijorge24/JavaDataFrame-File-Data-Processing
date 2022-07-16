package UnitTest;
import Composite.Directory;
import Composite.File;
import Factory.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import DatagramClass.*;
import Visitor.*;
import mapReduce.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTest {
    public static class main {
            /**
             * UnitTest: create unify test with the correct solutions to check the correct operation
             */
            @Test
            public void UnitTestDatagram() {
                FileFactory fichero;
                fichero=new CsvFactory();
                Files csv=fichero.createFile();
                Datagram test = csv.readFile("cities.csv");
                assertEquals("MA", test.at(3, "State"));
                assertEquals("Yakima", test.iat(2, 8));
                assertEquals(128, test.size());
                Datagram test2 = csv.readFile("cities2.csv");
                ArrayList<String> listTest = new ArrayList<>();
                listTest.add("41");
                listTest.add("42");
                listTest.add("42");
                assertEquals(listTest, test2.query("LatD", (a) -> Integer.parseInt(a) > 40 && Integer.parseInt(a) < 45));
                listTest.add("46");
                assertEquals(listTest, test2.sort("LatD", (String a, String b) -> a.compareTo(b)));
            }
            @Test
            public void TestMapReduce(){
                File csv2=new File(new CSV().readFile("cities2.csv"));
                mapReduce map=new mapReduce();
                assertEquals("YOUNGSTOWN, YANKTON, YAKIMA, WORCESTER, ",map.mapRed(csv2, "City", new joinCase(), 0, 0));
            }

            @Test
            public void TestCompositeVisitor(){
                Directory dir_datagram= new Directory("Directory of dataframes");
                Directory dir_csv=new Directory("CSV directory");
                Directory dir_txt=new Directory("TXT directory");
                dir_datagram.addChild(dir_csv);
                dir_datagram.addChild(dir_txt);
                File csv=new File(new CSV().readFile("cities.csv"));
                dir_csv.addChild(csv);
                File csv2=new File(new CSV().readFile("cities2.csv"));
                dir_csv.addChild(csv2);
                File txt=new File(new TXT().readFile("cities3.txt"));
                dir_txt.addChild(txt);
                List<File> list=new LinkedList<>();
                list.add(csv);
                list.add(csv2);
                assertEquals(260,dir_datagram.size());
                assertEquals(list,dir_csv.toList());
                Visitor visit =new averageVisitor("LonD");
                dir_datagram.accept(visit);
                assertEquals(93,visit.getValue());
                visit =new maxVisitor("LonD");
                dir_datagram.accept(visit);
                assertEquals(123,visit.getValue());
            }
    }
}
