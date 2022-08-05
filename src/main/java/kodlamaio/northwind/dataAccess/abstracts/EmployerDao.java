package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
