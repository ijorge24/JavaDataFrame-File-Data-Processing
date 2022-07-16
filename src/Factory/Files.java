package Factory;

import DatagramClass.Datagram;

/**
 * Interface that include the method to read a file and create a datagram
 */
public interface Files {
    Datagram readFile(String path);
}
