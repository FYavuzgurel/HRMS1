package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class WebSitesValidator {
public static Result valid (String webSites) {
		
		if(webSites.isEmpty()) {
			return new ErrorResult("Web sitesi alanı boş bırakılamaz.");
		}
		return new SuccesResult();
	}
} 
