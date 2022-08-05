package kodlamaio.northwind.core.utilities.verifications.abstracts;

import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.entities.concretes.User;

public interface HrmsApproveService {
	Result isApproved(User user);
}
