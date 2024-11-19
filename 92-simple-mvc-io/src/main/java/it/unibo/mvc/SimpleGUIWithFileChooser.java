package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser(){
        final JPanel innerTopPanel = new JPanel();
        innerTopPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        final JButton browseButton = new JButton();
        innerTopPanel.add(textField, BorderLayout.CENTER);
        innerTopPanel.add(browseButton,BorderLayout.LINE_END);
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(innerTopPanel, BorderLayout.NORTH);
    }

}
