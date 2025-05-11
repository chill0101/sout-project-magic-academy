package exceptions;

public class AlreadyTriedToLearn extends RuntimeException {
    public AlreadyTriedToLearn(String message) {
        super(message);
    }
}
