package it.unibo.mvc.api;

public interface GUI {

    /**
     * Sets window parameters and then displays it.
     */
    void display();

    /**
     * Raises an error to the user through the GUI.
     * @param error The error message
     */
    void errorDialog(String error);
}
