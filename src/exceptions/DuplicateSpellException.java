package exceptions;

public class DuplicateSpellException extends RuntimeException {
    public DuplicateSpellException(String message) {
        super(message);
    }


    public String getMessage() {
        return "* === Hechizo duplicado: " + super.getMessage() + "!!!";
    }

}
