package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.mvc.panels.TextEditorPanel;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Creates a new view composed of a TextEditorPanel.
     * @param controller The controller attached to this view
     */
    public SimpleGUI(final Controller controller) {
        final JPanel canvas = new TextEditorPanel(controller, frame);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Sets the size of the frame and pushes it to the view.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Creates a new View with SimpleGUI.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new Controller()).display();
    }

}
