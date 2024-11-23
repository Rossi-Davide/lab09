package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Standard implementation of the Controller interface.
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String stringToPrint;

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
