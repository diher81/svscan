package nl.solevision.svscan.exception;

abstract class CodedException extends RuntimeException {

    CodedException(final String message) {
        super(message);
    }

    CodedException(final String message, final Throwable e) {
        super(message, e);
    }

    abstract ExceptionCode code();

}
