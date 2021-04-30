package io.github.earthchen.ipplus360.awdb.exception;

import java.io.IOException;

/**
 * Signals that the underlying database has been closed.
 */
public class ClosedDatabaseException extends IOException {

    private static final long serialVersionUID = 1L;

    public ClosedDatabaseException() {
        super("The AW DB has been closed.");
    }
}
