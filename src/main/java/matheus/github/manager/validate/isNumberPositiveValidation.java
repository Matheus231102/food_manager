package matheus.github.manager.validate;

import matheus.github.manager.exceptions.NegativeNumberParameterException;

public class isNumberPositiveValidation {
    public static void validate(int value ) throws NegativeNumberParameterException {
	   if (value < 0) throw new NegativeNumberParameterException();
    }
}
