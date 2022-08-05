package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class PhoneNumberValidator {
	public static Result valid (String phoneNumber) {
		
		if(phoneNumber.isEmpty()) {
			return new ErrorResult("İsim alanı boş bırakılamaz.");
		}
		return new SuccesResult();
	}
}
