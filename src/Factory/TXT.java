package Factory;

import DatagramClass.Datagram;
import java.io.*;
import java.util.*;

/**
 * Class that treat a TXT file with the info separated by a space and the rows separated by an enter key
 */
public class TXT implements Files {
    /**
     * Method that read the file and create and fill a datagram
     * @param path the path of the file
     * @return a datagram with all the info of the file
     */
    @Override
    public Datagram readFile(String path) {
        File fichero = new File(path);
        String line;
        int i;
        int j = path.lastIndexOf('.');
        Datagram datagram = new Datagram(new LinkedHashMap<>(),path.substring(0,j));
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            if ((line = br.readLine()) != null) {
                StringTokenizer strtok = new StringTokenizer(line, " ");

                while (strtok.hasMoreTokens())
                    datagram.addLabel(strtok.nextToken().strip().replace("\"", ""));

                while ((line = br.readLine()) != null) {
                    i=0;
                    strtok = new StringTokenizer(line, " ");
                    while (strtok.hasMoreTokens()) {
                        datagram.addInfo(i,strtok.nextToken().strip().replace("\"", "").replace("-"," "));
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

