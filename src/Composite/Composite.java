package Composite;

import DatagramClass.*;
import Visitor.Visitor;

import java.util.*;

/**
 * Interface of Datagram Composite that contain several files in a directory
 */
public interface Composite {
    String getName();
    List<File> lookDatagrams(String name);
    int size();
    void setParent(Composite parent);
    void write();
    List<File> toList();
    void list();
    void accept (Visitor visitor);
}
