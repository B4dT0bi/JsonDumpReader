package de.badtobi.jsondumpreader;

import de.badtobi.jsondumpreader.entities.TestObject;
import de.badtobi.jsondumpreader.reader.CompressedDumpIterator;
import org.apache.commons.compress.compressors.CompressorException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class CompressedDumpIteratorTest {
    @Test
    public void testIterator() throws CompressorException {
        TestObject to = new TestObject();
        to.setLanguage("de");
        to.setValue("test");
        CompressedDumpIterator<TestObject> iterator = new CompressedDumpIterator<TestObject>(getClass().getResourceAsStream("compressed.entity.json.bz2"), TestObject.class);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(to, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = CompressorException.class)
    public void testIteratorWithException() throws CompressorException {
        CompressedDumpIterator<TestObject> iterator = new CompressedDumpIterator<TestObject>(getClass().getResourceAsStream("uncompressed.entity.json"), TestObject.class);
        Assert.fail(); // we should not reach this point
    }
}
