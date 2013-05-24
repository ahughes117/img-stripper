package img_stripper;

import java.io.*;

/**
 * A helper class for file input and output.
 *
 * @author deque
 *
 */
public class FileIO {

    /**
     * @param file file to get the bytes from
     * @return byte array that represents the given file
     * @throws IOException
     */
    public static byte[] getBytesFromFile(File file) throws IOException {
        byte[] data = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            data = new byte[(int) file.length()];
            fileInputStream.read(data);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
    
    /**
     * Writes a String into a File, using utf-8 encoding
     * 
     * @param aFileName
     * @param aContent
     * @throws IOException 
     */
    public static void exportTags(String aFileName, String aContent) throws IOException {
        BufferedWriter fr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aFileName), "UTF8"));
        fr.write(aContent);
        fr.close();
    }
}
