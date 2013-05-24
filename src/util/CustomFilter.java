
package util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Alex Hughes
 */
public class CustomFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = this.getExtension(f);
        if (extension != null) {
            if (extension.equalsIgnoreCase("jpg") || 
                    extension.equalsIgnoreCase("gif") ||
                    extension.equalsIgnoreCase("tiff") ||
                    extension.equalsIgnoreCase("bmp") ||
                    extension.equalsIgnoreCase("png")
                ) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return ".txt";
    }

    private String getExtension(File aFile) {
        String ext = null;
        String s = aFile.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }

        return ext;
    }
}