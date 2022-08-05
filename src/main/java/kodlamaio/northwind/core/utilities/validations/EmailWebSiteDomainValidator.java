package kodlamaio.northwind.core.utilities.validations;

import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;

public class EmailWebSiteDomainValidator {
	public static Result valid(String webSites, String email) {
		
		String [] splitWebSites = webSites.split("www.", 2);
		String [] splitEmail = email.split("@", 2);
		
		if(!(splitWebSites[1].contains(splitEmail[1]))) {
			return new ErrorResult("Mail adresi ve web sitesi aynı domaine kayıtlı olmalıdır.");
		}	
			return new SuccesResult();	
	}
}
