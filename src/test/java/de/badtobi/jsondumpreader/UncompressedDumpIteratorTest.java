package de.badtobi.jsondumpreader;

import de.badtobi.jsondumpreader.entities.TestObject;
import de.badtobi.jsondumpreader.reader.UncompressedDumpIterator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by b4dt0bi on 26.05.16.
 */
public class UncompressedDumpIteratorTest {
    @Test
    public void testIterator() {
        TestObject to = new TestObject();
        to.setLanguage("de");
        to.setValue("test");
        UncompressedDumpIterator<TestObject> iterator = new UncompressedDumpIterator<TestObject>(getClass().getResourceAsStream("uncompressed.entity.json"), TestObject.class);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(to, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }
}
