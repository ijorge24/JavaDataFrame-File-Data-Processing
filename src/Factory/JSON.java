package Factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

import java.util.*;

import DatagramClass.*;

/**
 * Class that treat a JSON file
 */
public class JSON implements Files {
    /**
     * Method that reads a JSON file and write all the info in a datagram
     * @param path the path of the file
     * @return a datagram with all the info of the file
     */
    @Override
    public Datagram readFile(String path) {
        File fichero = new File(path);
        String line;
        int i=0;
        StringTokenizer strtok;
        int j = path.lastIndexOf('.');
        Datagram datagram = new Datagram(new LinkedHashMap<>(),path.substring(0,j));
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            if ((line = br.readLine()) != null) {
                line = br.readLine();
                line = br.readLine();
                while ((!line.equals("},"))&&(!line.equals("}"))) {
                    strtok = new StringTokenizer(line, ":");
                    datagram.addLabel(strtok.nextToken().strip().replace("\"", ""));
                    datagram.addInfo(i,strtok.nextToken().strip().replace("\"", "").replace(",",""));
                    line = br.readLine().strip();
                    i++;
                }
                while ((line = br.readLine()) != null&&(!line.equals("]"))) {
                    line = br.readLine();
                    i=0;
                    while ((!line.equals("},"))&&(!line.equals("}"))) {
                        strtok = new StringTokenizer(line, ":");
                        String label=strtok.nextToken();
                        datagram.addInfo(i,strtok.nextToken().strip().replace("\"", "").replace(",",""));
                        line = br.readLine().strip();
                        i++;
                    }

                }
            }
        } catch
        (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return datagram;
    }
}
