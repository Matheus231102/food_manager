package matheus.github.manager.exceptions;

public class NegativeNumberParameterException extends Exception {
    public NegativeNumberParameterException(String message) {
	   super(message);
    }

    public NegativeNumberParameterException() {
	   super();
    }
}
