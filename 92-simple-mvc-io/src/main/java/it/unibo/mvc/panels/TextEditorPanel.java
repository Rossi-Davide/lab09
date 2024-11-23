package it.unibo.mvc.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unibo.mvc.Controller;

import java.awt.event.ActionEvent;


public final class TextEditorPanel extends JPanel{
    
    public TextEditorPanel(final Controller controller,final JFrame frame){
        this.setLayout(new BorderLayout()); 
        final JTextArea textInput = new JTextArea();
        this.add(textInput, BorderLayout.CENTER);
        final JButton saveButton = new JButton("Save");
        this.add(saveButton,BorderLayout.SOUTH);
        
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeString(textInput.getText());
                }catch (IOException ex){
                    JOptionPane.showMessageDialog(frame, ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
    }
}
