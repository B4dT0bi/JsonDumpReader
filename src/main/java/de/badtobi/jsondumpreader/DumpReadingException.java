package de.badtobi.jsondumpreader;

/**
 * Created by b4dt0bi on 25.05.16.
 */
public class DumpReadingException extends RuntimeException {
    public DumpReadingException() {
    }

    public DumpReadingException(String s) {
        super(s);
    }

    public DumpReadingException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DumpReadingException(Throwable throwable) {
        super(throwable);
    }

    public DumpReadingException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
