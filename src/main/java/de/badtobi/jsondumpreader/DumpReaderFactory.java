package de.badtobi.jsondumpreader;

import de.badtobi.jsondumpreader.reader.CompressedDumpReader;
import de.badtobi.jsondumpreader.reader.UncompressedDumpReader;
import org.apache.commons.compress.compressors.CompressorException;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by b4dt0bi on 25.05.16.
 */
public class DumpReaderFactory {

    public static DumpReader getUncompressedDumpReader(String pathToFile) throws FileNotFoundException {
        return new UncompressedDumpReader(pathToFile);
    }

    public static DumpReader getCompressedDumpReader(String pathToFile) throws FileNotFoundException, CompressorException {
        return new CompressedDumpReader(pathToFile);
    }

    public static DumpReader getUncompressedDumpReader(InputStream is) {
        return new UncompressedDumpReader(is);
    }

    public static DumpReader getCompressedDumpReader(InputStream is) throws CompressorException {
        return new CompressedDumpReader(is);
    }

}
