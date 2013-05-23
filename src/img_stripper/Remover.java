package img_stripper;

import java.io.File;
import java.io.IOException;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.ImageWriteException;

/**
 * The remover class
 *
 * @author ahughes
 */
public class Remover {

    /**
     * Gets a directory and removes all EXIF information of the images in it
     *
     * @param aRawDir
     * @param aProcDir
     * @throws IOException
     * @throws ImageReadException
     * @throws ImageWriteException
     */
    public static void remove(File [] aFilelist) throws IOException,
            ImageReadException, ImageWriteException {
        
        EXIFRemover xr;
        for (int i = 0; i < aFilelist.length; i++) {
            xr = new EXIFRemover(aFilelist[i]);
            xr.removeEXIFData(aFilelist[i]);
        }
    }
}
