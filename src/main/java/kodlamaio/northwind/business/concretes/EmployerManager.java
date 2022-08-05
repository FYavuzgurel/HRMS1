package kodlamaio.northwind.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.EmployerService;
import kodlamaio.northwind.core.utilities.result.DataResult;
import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;
import kodlamaio.northwind.core.utilities.result.SuccessDataResult;
import kodlamaio.northwind.core.utilities.validations.CompanyNameValidator;
import kodlamaio.northwind.core.utilities.validations.EmailValidator;
import kodlamaio.northwind.core.utilities.validations.EmailWebSiteDomainValidator;
import kodlamaio.northwind.core.utilities.validations.PasswordValidator;
import kodlamaio.northwind.core.utilities.validations.PhoneNumberValidator;
import kodlamaio.northwind.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.northwind.core.utilities.verifications.abstracts.HrmsApproveService;
import kodlamaio.northwind.dataAccess.abstracts.EmployerDao;
import kodlamaio.northwind.entities.concretes.Employer;
 
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private HrmsApproveService hrmsApproveService;
	private EmailVerificationService emailVerificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, HrmsApproveService hrmsApproveService,
			EmailVerificationService emailVerificationService) {
		super();
		this.employerDao = employerDao;
		this.hrmsApproveService = hrmsApproveService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"iş verenler listelendi");
	}
	
	public Result isEmailExist(String email) {
		if((this.employerDao.findByEmail(email) == null)) {
			return new SuccesResult();
		}
		return new ErrorResult();
		
	}

	@Override
	public Result add(Employer employer) {
		
		Result companyNameValid = CompanyNameValidator.validation(employer.getCompanyName());
		Result emailValid = EmailValidator.validation(employer.getEmail());
		Result emailWebSitesDomainValid = EmailWebSiteDomainValidator.valid(employer.getWebAddress(),employer.getEmail());
		Result passwordValid = PasswordValidator.valid(employer.getPassword(), employer.getPassword());
		Result phoneNumberValid= PhoneNumberValidator.valid(employer.getPhoneNumber());
		
		if(!companyNameValid.isSuccess()) {
			return new ErrorResult(companyNameValid.getMessage());
		}
		else if(!emailValid.isSuccess()) {
			return new ErrorResult(emailValid.getMessage());
		}
		else if(!emailWebSitesDomainValid.isSuccess()) {
			return new ErrorResult(emailWebSitesDomainValid.getMessage());
		}
		else if(!passwordValid.isSuccess()) {
			return new ErrorResult(passwordValid.getMessage());
		}
		else if(!phoneNumberValid.isSuccess()) {
			return new ErrorResult(phoneNumberValid.getMessage());
		}
		else if(!this.hrmsApproveService.isApproved(employer).isSuccess()) {
			return new ErrorResult("Üyelik sistem personeli tarafından onaylanmamıştır.");
		}
		else if(!this.emailVerificationService.verifyEmail(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Email doğrulaması yapılmadı");
		}
		else if(!this.isEmailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Mail adresi daha önce kullanılmıştır");
		}
		
		
		this.employerDao.save(employer);
		return new SuccesResult("Employer eklendi");
	}
	
	
}
