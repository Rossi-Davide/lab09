package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String stringToPrint;

    @Override
    public void setStringToPrint(final String inpuString) throws NullPointerException {
        Objects.requireNonNull(inpuString);
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
    public void printString() throws IllegalStateException {
        if( stringToPrint == null) {
            throw new IllegalArgumentException("No string was set to be printed");
        }
        System.out.println(stringToPrint);
        history.add(stringToPrint);
        stringToPrint = null;
    }

}
