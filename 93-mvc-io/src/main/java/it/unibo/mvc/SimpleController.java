package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String stringToPrint;

    @Override
    public void setStringToPrint(String inpuString) throws NullPointerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStringToPrint'");
    }

    @Override
    public String getNextStringToPrint() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextStringToPrint'");
    }

    @Override
    public List<String> getHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
    }

    @Override
    public void printString() throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printString'");
    }

}
