package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.mvc.panels.TextEditorPanel;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Builds a GUI composed of a TextEditorPanel and a panel to select the destination file.
     * @param controller The controller that works as listener for the button events
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.setEditable(false);
        final JButton browseButton = new JButton("Browse");
        topPanel.add(textField, BorderLayout.CENTER);
        topPanel.add(browseButton, BorderLayout.LINE_END);
        canvas.add(topPanel, BorderLayout.NORTH);
        canvas.add(new TextEditorPanel(controller, frame), BorderLayout.CENTER);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int res = fileChooser.showSaveDialog(canvas); 
                switch (res) {
                    case JFileChooser.APPROVE_OPTION:
                        controller.setCurrentFile(fileChooser.getSelectedFile());
                        textField.setText(controller.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Error opening file", null, JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });
    }


    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Creates a new View with SimpleGUIWithFileChooser.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }

}
