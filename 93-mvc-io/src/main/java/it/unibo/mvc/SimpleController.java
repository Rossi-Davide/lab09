package it.unibo.mvc;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Standard implementation of the Controller interface.
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history;
    private String stringToPrint;

    /**
     * Builds a new I/O controller.
     * @param printString thie string that will be printed to stdout
     * @param oldHistory the history of printed strings so far
     */
    public SimpleController(final String printString, final List<String> oldHistory) {
        stringToPrint = printString;
        history = List.copyOf(oldHistory);
    }

    /**
     * Builds a new I/O controller with no string set to print and an empty history.
     */
    public SimpleController() {
        this("", new ArrayList<>());
    }

    @Override
    public void setStringToPrint(final String inpuString) {
        Objects.requireNonNull(inpuString);
        stringToPrint = inpuString;
    }

    @Override
    public String getNextStringToPrint() {
        return stringToPrint;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public void printString() {
        if (stringToPrint == null) {
            throw new IllegalStateException("No string was set to be printed");
        }
        System.out.println(stringToPrint); //NOPMD the exercise requires writing to stdout
        history.add(stringToPrint);
        stringToPrint = null;
    }

}
