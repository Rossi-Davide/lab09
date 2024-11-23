package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * Sets the next string that will be printed to stdout.
     * @param inpuString The string to print to stdout
     * @throws NullPointerException if a null string is passed
     */
    void setStringToPrint(String inpuString);

    /**
     * Returns the string that will be printed to stdout.
     * @return the string to print
     */
    String getNextStringToPrint();

    /**
     * Returns the history of strings printed to stdout.
     * @return the list of strings to print
     */
    List<String> getHistory();

    /**
     * Prints the string specified with setStringToPrint to stdout. 
     * Then it adds the string to the history
     * @throws IllegalStateException if no string is set to be printed
     */
    void printString();
}
