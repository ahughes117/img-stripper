package util;

import javax.swing.*;
import java.io.*;

/**
 * Wrapper class for file choosers
 * @author Alex Hughes
 */
public class CustomChooser {
    
    public static final int CANCEL_OPTION = JFileChooser.CANCEL_OPTION;
    private JFileChooser openChooser;
    private JFileChooser saveChooser;
    private File file;

    /*
     * Opens a JFileChooser, for opening or for saving depending on the parameter
     * aChooser. If cancel option is selected, file is casted as null.
     * ahughes
     */
    public CustomChooser(JFrame aParentFrame, String aChooser) {
        int result;

        if (aChooser.equalsIgnoreCase("open")) {
            openChooser = new JFileChooser();
            openChooser.setAcceptAllFileFilterUsed(false);
            openChooser.addChoosableFileFilter(new CustomFilter());

            result = openChooser.showOpenDialog(aParentFrame);
            if (result != JFileChooser.CANCEL_OPTION) {
                file = openChooser.getSelectedFile();
                System.out.println("File has been chosen");
            } else {
                file = null;
                System.out.println("File Opening Cancelled");
            }
        } else if (aChooser.equalsIgnoreCase("save")) {
            saveChooser = new JFileChooser();
            saveChooser.setAcceptAllFileFilterUsed(false);
            saveChooser.addChoosableFileFilter(new CustomFilter());
            result = saveChooser.showSaveDialog(aParentFrame);
            if (result != JFileChooser.CANCEL_OPTION) {
                file = saveChooser.getSelectedFile();
                System.out.println("File has been prepared for writing");
            } else {
                file = null;
                System.out.println("File Saving Cancelled");
            }
        }
    }

    public File getFile() {
        return file;
    }
}