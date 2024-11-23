package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    void setStringToPrint(String inpuString) throws NullPointerException;

    String getNextStringToPrint();

    List<String> getHistory();

    void printString() throws IllegalStateException;
}
