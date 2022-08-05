package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class CompanyNameValidator {
	public static Result validation(String companyName) {
		
		if(companyName.isEmpty()) {
			return new ErrorResult("Şirket isim alanı boş bırakılamaz");
		}
		else {
			return new SuccesResult();
		}
	}
}
