package kodlamaio.northwind.core.utilities.verifications.concretes;

import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;
import kodlamaio.northwind.core.utilities.verifications.abstracts.HrmsApproveService;
import kodlamaio.northwind.entities.concretes.User;

public class HrmsApproveManager implements HrmsApproveService{

	@Override
	public Result isApproved(User user) {

		return new SuccesResult();
	}

}
