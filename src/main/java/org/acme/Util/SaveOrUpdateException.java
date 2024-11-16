package org.acme.Util;

import com.ibm.db2.jcc.am.BatchUpdateException;

public class SaveOrUpdateException extends Exception {

    @Deprecated
    public static Throwable extractCause(String message, Throwable exception) {
        while (exception.getCause() != null) {
            exception = exception.getCause();
        }
        return exception;
    }

    public static Throwable extractCauseIfHasBatchUpdateException(Throwable exception) {
        var cause = exception;
        var hasBatchUpdateException = false;
        while (cause.getCause() != null) {
            if (BatchUpdateException.class.equals(cause.getClass())) {
                hasBatchUpdateException = true;
            }
            cause = cause.getCause();
        }
        return hasBatchUpdateException ? cause : exception;
    }

    public SaveOrUpdateException(String message, Throwable exception) {
        super(message, extractCauseIfHasBatchUpdateException(exception));
    }

}
