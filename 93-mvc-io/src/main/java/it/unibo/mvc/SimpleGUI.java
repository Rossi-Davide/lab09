package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private Controller controller;

    public SimpleGUI(){
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
                controller.setStringToPrint(enterString.getText());
                controller.printString();
            }
            
        });
        showHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                for(final String el : controller.getHistory()) {
                    historyArea.append(el);
                } 
            }
            
        });
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public void setController(final Controller observer){
        controller = observer;
    }

    public static void main(final String[] args) {
        new SimpleGUI().setController(new SimpleController());;
    }
}
