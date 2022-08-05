package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class PasswordValidator { 
public static Result valid (String password, String repassword) {
		
		if(password.isEmpty()) {
			return new ErrorResult("Şifre alanı boş bırakılamaz.");
		}
		
		if(repassword.isEmpty()) {
			return new ErrorResult("Şifre tekrarı alanı boş bırakılamaz.");
		}
		return new SuccesResult();
	}
}
