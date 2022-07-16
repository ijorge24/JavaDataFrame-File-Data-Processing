package Observer;
import DatagramClass.Datagram;
import Factory.*;

public class testDynamicObserver {
    public static void main(String[] args)  {
        System.out.println("Test Dynamic Proxy and Observer");
        System.out.println("Creating FilesFactory...");
        FileFactory fichero;
        System.out.println("Dir_datagram created");
        System.out.println("Creating Datagram...");
        String ficheroPath="cities.csv";
        fichero=new CsvFactory();
        Files csv=fichero.createFile();
        Datagram datagram=csv.readFile(ficheroPath);
        System.out.println("Datagram Created");
        System.out.println("Creating Observers...");
        datagramObserver aFoo = (datagramObserver) dynamicProxy.newInstance(new logObserver(datagram));
        datagramObserver aFooQuery = (datagramObserver) dynamicProxy.newInstance(new queryObserver(datagram));
        System.out.println("Observers created");
        System.out.println("executing instruction iat with observers class...");
        System.out.println(aFoo.at(4,"LonD"));
        System.out.println(aFooQuery.at(4,"LonD"));
        System.out.println("at instruction executed");
        System.out.println("get saved instructions");
        aFoo.listFunctions();
        aFooQuery.listFunctions();
        System.out.println("executing instruction iat with observers class...");
        System.out.println(aFoo.iat(4,4));
        System.out.println(aFooQuery.iat(4,4));
        System.out.println("iat instruction executed");
        System.out.println("get saved instructions");
        aFoo.listFunctions();
        aFooQuery.listFunctions();
        System.out.println("executing instruction sort with observers class...");
        System.out.println(aFoo.sort("LonD", (String a,String b)->a.compareTo(b)));
        System.out.println(aFooQuery.sort("LonD", (String a,String b)->a.compareTo(b)));
        System.out.println("sort instruction executed");
        System.out.println("get saved instructions");
        aFoo.listFunctions();
        aFooQuery.listFunctions();
        System.out.println("executing instruction query with observers class...");
        System.out.println(aFoo.query("LonD", (a)->Integer.parseInt(a)>90&&Integer.parseInt(a)<110));
        System.out.println(aFooQuery.query("LonD", (a)->Integer.parseInt(a)>90&&Integer.parseInt(a)<110));
        System.out.println("query instruction executed");
        System.out.println("get saved instructions");
        aFoo.listFunctions();
        aFooQuery.listFunctions();
    }
}
