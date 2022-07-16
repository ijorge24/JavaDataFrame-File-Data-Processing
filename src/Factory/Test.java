package Factory;
import DatagramClass.Datagram;

public class Test {
    public static void main(String[] args)  {

        FileFactory fichero;
        Datagram datagram=new Datagram(null,null);
        String ficheroPath;
        for (int i=0;i<3;i++) {
            switch (i) {
                case 0 -> {
                    fichero=new TxtFactory();
                    Files txt=fichero.createFile();
                    System.out.println("Reading txt file...");
                    ficheroPath = "cities3.txt";
                    datagram = txt.readFile(ficheroPath);
                }
                case 1 -> {
                    fichero=new CsvFactory();
                    Files csv=fichero.createFile();
                    System.out.println("Reading csv file...");
                    ficheroPath = "cities.csv";
                    datagram = csv.readFile(ficheroPath);
                }
                case 2 -> {
                    fichero=new JsonFactory();
                    Files json=fichero.createFile();
                    System.out.println("Reading json file...");
                    ficheroPath = "cities.json";
                    datagram = json.readFile(ficheroPath);
                }
            }
            datagram.Write();
            System.out.println("Test at->row=10, label=LonD");
            System.out.println(datagram.at(10, "LonD"));
            System.out.println("Test iat->row=10, column=0");
            System.out.println(datagram.iat(10, 0));
            System.out.println("Test sort LatD from lowest to highest");
            System.out.println(datagram.sort("LatD", (String a, String b) -> a.compareTo(b)));
            System.out.println("Test sort alphabetically arranged according to the third character of the city");
            System.out.println(datagram.sort("City", (String a, String b) -> a.substring(2).compareTo(b.substring(2))));
            System.out.println("Test query state=ohio");
            System.out.println(datagram.query("State", (String a) -> a.equals("OH")));
            System.out.println("Test query values between 90 and 110 of LonD");
            System.out.println(datagram.query("LonD", (a) -> Integer.parseInt(a) > 90 && Integer.parseInt(a) < 110));
        }
    }
}
