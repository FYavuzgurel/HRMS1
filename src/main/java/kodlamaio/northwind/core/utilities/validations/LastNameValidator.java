package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class LastNameValidator {

	public static Result validation(String lastName) {
		
		if(lastName.isEmpty()) {
			return new ErrorResult("Soyisim alanı boş bırakılamaz");
		}
		else {
			return new SuccesResult();
		}
	}
}
