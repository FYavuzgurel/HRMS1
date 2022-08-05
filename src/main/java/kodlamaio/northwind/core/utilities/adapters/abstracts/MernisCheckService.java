package kodlamaio.northwind.core.utilities.adapters.abstracts;

import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.entities.concretes.Candidate;

public interface MernisCheckService {
	Result  checkIfPersonIsReal( Candidate candidate);
}
