package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller controller;

    /**
     * Standard view.
     * The GUI is composed of a text field, a text area and two buttons print and history
     * @param listener The controller that will listen for events
     */
    public SimpleGUI(final Controller listener) {
        this.controller = new SimpleController(listener.getNextStringToPrint(), listener.getHistory());
        /*
         * UI
         */
        final JPanel canvas = new JPanel(new BorderLayout());
        final JTextField enterString = new JTextField();
        canvas.add(enterString, BorderLayout.NORTH);
        final JTextArea historyArea = new JTextArea();
        canvas.add(historyArea, BorderLayout.CENTER);
        final JPanel pSouth = new JPanel(new BorderLayout());
        final JButton printButton = new JButton("Print");
        final JButton showHistoryButton = new JButton("Show history");
        pSouth.add(printButton, BorderLayout.CENTER);
        pSouth.add(showHistoryButton, BorderLayout.LINE_END);
        canvas.add(pSouth, BorderLayout.SOUTH);
        /*
         * Handlers
         */
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.setStringToPrint(enterString.getText());
                    controller.printString();
                }  catch (IllegalStateException ex) {
                    showError(ex.getMessage());
                }
            }
        });
        showHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                historyArea.setText(null);
                for (final String el : controller.getHistory()) {
                    historyArea.append(el + "\n");
                } 
            }
        });
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        windowDimension.width = (int) windowDimension.getWidth() / PROPORTION;
        windowDimension.height = (int) windowDimension.getHeight() / PROPORTION;
        frame.setSize(windowDimension);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Shows error dialog.
     * @param msg
     */
    public void showError(final String msg) {
        JOptionPane.showMessageDialog(frame, "ERROR", msg, 0);
    }

    /**
     * Creates a new view using SimpleGUI.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController());
    }
}
