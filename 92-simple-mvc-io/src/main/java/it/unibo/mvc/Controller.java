package it.unibo.mvc;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final  String DEFAULT_FILE_NAME = "output.txt";
    private static final String DEFAULT_PATH = System.getProperty("user.home") + File.separator + DEFAULT_FILE_NAME;
    private File currFile = new File(DEFAULT_PATH);

    /**
     *Sets the new given file as the file to write to.
     *
     *@param newFile the new file to write to
     */
    public void setCurrentFile(final File newFile) {
        currFile = newFile;
    }

    /**
     * Returns the file the controller is set to write to.
     * @return the file specified for writing
     */
    public File getCurrentFile() {
        return currFile;
    }

    /**
     * Get the absolute path where the file the controller writes to is located.
     * @return the absolute path to the file as a string 
     */
    public String getPath() {
        return currFile.getAbsolutePath();
    }

    /**
     * Writes a string of characters to the file set with UTF-8 encoding.
     * @param inputString the string that will be written on the file
     * @throws IOException if there is any error trying to access the file
     */
    public void writeString(final String inputString) throws IOException {
        try (
            FileOutputStream filStream = new FileOutputStream(getPath());
            BufferedOutputStream buffStream = new BufferedOutputStream(filStream);
            DataOutputStream outStream = new DataOutputStream(buffStream);
            ) {
            outStream.writeUTF(inputString);
        }
    }
}
