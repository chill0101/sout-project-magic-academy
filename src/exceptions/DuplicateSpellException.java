package exceptions;

public class DuplicateSpellException extends RuntimeException {
    public DuplicateSpellException(String message) {
        super(message);
    }
}
