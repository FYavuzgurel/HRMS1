package kodlamaio.northwind.core.utilities.verifications.abstracts;

import kodlamaio.northwind.core.utilities.result.Result;

public interface EmailVerificationService {
	
	Result verifyEmail(String email);
}
