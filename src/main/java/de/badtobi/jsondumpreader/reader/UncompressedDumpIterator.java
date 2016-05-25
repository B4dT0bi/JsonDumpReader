package de.badtobi.jsondumpreader.reader;

import com.google.gson.Gson;
import de.badtobi.jsondumpreader.DumpReader;
import de.badtobi.jsondumpreader.DumpReaderFactory;
import org.apache.commons.compress.compressors.CompressorException;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class UncompressedDumpIterator<T> implements Iterator<T> {

    DumpReader dumpReader;
    private Gson gson = new Gson();
    private T nextObject = null;
    Class<T> typeParameterClass;

    protected UncompressedDumpIterator() {}

    public UncompressedDumpIterator(String pathToFile, Class<T> typeParameterClass) throws FileNotFoundException {
        dumpReader = DumpReaderFactory.getUncompressedDumpReader(pathToFile);
        this.typeParameterClass = typeParameterClass;
        init();
    }

    public UncompressedDumpIterator(InputStream is, Class<T> typeParameterClass) {
        dumpReader = DumpReaderFactory.getUncompressedDumpReader(is);
        this.typeParameterClass = typeParameterClass;
        init();
    }

    void init() {
        dumpReader.nextJsonLine(); // skip first line
        readEntity();
    }

    private void readEntity() {
        String jsonString = dumpReader.nextJsonLine();
        if (jsonString.endsWith(",")) {
            jsonString = jsonString.substring(0, jsonString.length() - 1);
        }
        if (jsonString == null || jsonString.isEmpty() || jsonString.equals("]")) {
            nextObject = null;
        } else {
            nextObject = gson.fromJson(jsonString, typeParameterClass);
        }
    }

    public boolean hasNext() {
        return nextObject != null;
    }

    public T next() {
        T result = nextObject;
        readEntity();
        return result;
    }
}
