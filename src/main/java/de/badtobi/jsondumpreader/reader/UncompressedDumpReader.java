package de.badtobi.jsondumpreader.reader;

import de.badtobi.jsondumpreader.DumpReader;
import de.badtobi.jsondumpreader.DumpReadingException;

import java.io.*;

/**
 * Created by b4dt0bi on 25.05.16.
 */
public class UncompressedDumpReader implements DumpReader {
    private BufferedReader br;

    public UncompressedDumpReader(String pathToFile) throws FileNotFoundException {
        this(new FileInputStream(pathToFile));
    }

    public UncompressedDumpReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    public String nextJsonLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new DumpReadingException(e);
        }
    }

    public void rewind() {
        try {
            br.reset();
        } catch (IOException e) {
            throw new DumpReadingException(e);
        }
    }
}
