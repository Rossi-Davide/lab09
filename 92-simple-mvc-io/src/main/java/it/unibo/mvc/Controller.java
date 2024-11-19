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


    public void setCurrentFile(final File newFile) {
        currFile=newFile;
    }

    public File getCurrentFile() {
        return currFile;
    }

    public String getPath() {
        return currFile.getAbsolutePath();
    }

    public void writeString(final String inputString) throws IOException {
        try (
            final FileOutputStream filStream = new FileOutputStream(getPath());
            final BufferedOutputStream buffStream = new BufferedOutputStream(filStream);
            final DataOutputStream outStream = new DataOutputStream(buffStream);
            ) {
            System.out.println(inputString);
            outStream.writeUTF(inputString);
        }
    }
}
