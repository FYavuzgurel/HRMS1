package kodlamaio.northwind.core.utilities.verifications.concretes;

import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;
import kodlamaio.northwind.core.utilities.verifications.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(String email) {
		return new SuccesResult();
	}

}
