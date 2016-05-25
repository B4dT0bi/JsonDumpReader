package de.badtobi.jsondumpreader;

import org.apache.commons.compress.compressors.CompressorException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by b4dt0bi on 25.05.16.
 */
public class CompressedDumpReaderTest {
    @Test
    public void testReadBzip2() throws FileNotFoundException, CompressorException {
        DumpReader dumpReader = DumpReaderFactory.getCompressedDumpReader(getClass().getResourceAsStream("compressed.json.bz2"));
        dumpReader.nextJsonLine(); // first line needs to be skipped as it is the start of the JSON Array "["
        Assert.assertTrue(dumpReader.nextJsonLine().contains("universum"));
        Assert.assertTrue(dumpReader.nextJsonLine().contains("happiness"));
    }

    @Test
    public void testReadGzip() throws FileNotFoundException, CompressorException {
        DumpReader dumpReader = DumpReaderFactory.getCompressedDumpReader(getClass().getResourceAsStream("compressed.json.gz"));
        dumpReader.nextJsonLine(); // first line needs to be skipped as it is the start of the JSON Array "["
        Assert.assertTrue(dumpReader.nextJsonLine().contains("universum"));
        Assert.assertTrue(dumpReader.nextJsonLine().contains("happiness"));
    }
}
