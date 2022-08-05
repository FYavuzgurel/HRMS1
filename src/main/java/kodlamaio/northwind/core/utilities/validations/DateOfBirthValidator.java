package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class DateOfBirthValidator {
	public static Result validation(int i) {
		
		if(Integer.toString(i) == null) {
			return new ErrorResult("Doğum tarihi alanı boş bırakılamaz");
		}
		else {
			return new SuccesResult();
		}
	}
}
