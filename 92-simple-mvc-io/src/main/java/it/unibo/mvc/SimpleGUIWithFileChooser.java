package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser(final Controller controller){
        final JPanel innerTopPanel = new JPanel();
        innerTopPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.setEditable(false);
        final JButton browseButton = new JButton("Browse");
        innerTopPanel.add(textField, BorderLayout.CENTER);
        innerTopPanel.add(browseButton,BorderLayout.LINE_END);
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(innerTopPanel, BorderLayout.NORTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int res = fileChooser.showSaveDialog(mainPanel); 
                if (res == JFileChooser.APPROVE_OPTION){
                    controller.setCurrentFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getPath());
                }
            }
            
        });
    }


    private void display() {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }

}
