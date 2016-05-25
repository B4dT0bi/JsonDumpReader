package de.badtobi.jsondumpreader;

/**
 * Created by b4dt0bi on 25.05.16.
 *
 * @author Tobias Boese
 */
public interface DumpReader {
    /**
     * Returns the next JSON object (as string) or null if the end of the dump has been reached.
     *
     * @return string or null
     * @throws DumpReadingException
     */
    String nextJsonLine();
    void rewind();
}
