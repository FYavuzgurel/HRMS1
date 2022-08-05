package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Employee;
import kodlamaio.northwind.entities.concretes.Employer;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	Employer findByEmail(String email);
}
