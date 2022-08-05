package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class IdentificationNumberValidator {
public static Result valid (String identificationNumber) {
		
		if(identificationNumber.isEmpty()) {
			return new ErrorResult("T.C. kimlik alanı boş bırakılamaz.");
		}
		return new SuccesResult();
	}
}
