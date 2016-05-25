package de.badtobi.jsondumpreader.reader;

import de.badtobi.jsondumpreader.DumpReader;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by b4dt0bi on 25.05.16.
 */
public class CompressedDumpReader extends UncompressedDumpReader implements DumpReader {

    public CompressedDumpReader(String pathToFile) throws FileNotFoundException, CompressorException {
        this(new FileInputStream(pathToFile));
    }

    public CompressedDumpReader(InputStream is) throws CompressorException {
        super(new CompressorStreamFactory().createCompressorInputStream(new BufferedInputStream(is)));
    }
}
