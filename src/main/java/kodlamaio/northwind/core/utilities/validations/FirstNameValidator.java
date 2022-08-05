package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class FirstNameValidator {

	public static Result validation(String firstName) {
		
		if(firstName.isEmpty()) {
			return new ErrorResult("İsim alanı boş bırakılamaz");
		}
		else {
			return new SuccesResult();
		}
	}
}
