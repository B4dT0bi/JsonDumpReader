package de.badtobi.jsondumpreader.reader;

import de.badtobi.jsondumpreader.DumpReaderFactory;
import org.apache.commons.compress.compressors.CompressorException;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class CompressedDumpIterator<T> extends UncompressedDumpIterator<T> {

    public CompressedDumpIterator(String pathToFile, Class<T> typeParameterClass) throws FileNotFoundException, CompressorException {
        dumpReader = DumpReaderFactory.getCompressedDumpReader(pathToFile);
        this.typeParameterClass = typeParameterClass;
        init();
    }

    public CompressedDumpIterator(InputStream is, Class<T> typeParameterClass) throws CompressorException {
        dumpReader = DumpReaderFactory.getCompressedDumpReader(is);
        this.typeParameterClass = typeParameterClass;
        init();
    }
}
