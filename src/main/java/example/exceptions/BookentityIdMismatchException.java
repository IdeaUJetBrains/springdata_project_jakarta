package example.exceptions;

public class BookentityIdMismatchException extends Throwable {

    public BookentityIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    public BookentityIdMismatchException(String message) {
        super(message);
    }
}
