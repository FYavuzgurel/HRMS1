package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class EmailValidator {
public static Result validation(String email) {
		
		if(email.isEmpty()) {
			return new ErrorResult("email alanı boş bırakılamaz");
		}
		else {
			return new SuccesResult();
		}
	}
}
