package kodlamaio.northwind.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.utilities.result.DataResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;
import kodlamaio.northwind.core.utilities.result.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.UserDao;
import kodlamaio.northwind.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
 
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccesResult("Kullanıcı eklendi");
	}
}
 