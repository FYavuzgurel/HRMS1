package kodlamaio.northwind.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.EmployerService;
import kodlamaio.northwind.core.utilities.result.DataResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;
import kodlamaio.northwind.core.utilities.result.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.EmployerDao;
import kodlamaio.northwind.entities.concretes.Employer;
 
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccesResult("Employer eklendi");
	}
	
	
}