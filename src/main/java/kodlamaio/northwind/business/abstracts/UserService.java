package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.entities.concretes.User;

public interface UserService {
	public List<User> getAll();
}
