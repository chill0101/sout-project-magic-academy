package exceptions;

public class DuplicateStudentException extends RuntimeException {
    public DuplicateStudentException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "* === Estudiante duplicado: " + super.getMessage() + "!!!";
    }
}
