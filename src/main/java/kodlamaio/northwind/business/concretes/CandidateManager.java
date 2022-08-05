package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.CandidateService;
import kodlamaio.northwind.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.northwind.core.utilities.result.DataResult;
import kodlamaio.northwind.core.utilities.result.ErrorResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.core.utilities.result.SuccesResult;
import kodlamaio.northwind.core.utilities.result.SuccessDataResult;
import kodlamaio.northwind.core.utilities.validations.DateOfBirthValidator;
import kodlamaio.northwind.core.utilities.validations.EmailValidator;
import kodlamaio.northwind.core.utilities.validations.FirstNameValidator;
import kodlamaio.northwind.core.utilities.validations.IdentificationNumberValidator;
import kodlamaio.northwind.core.utilities.validations.LastNameValidator;
import kodlamaio.northwind.core.utilities.validations.PasswordValidator;
import kodlamaio.northwind.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.northwind.dataAccess.abstracts.CandidateDao;
import kodlamaio.northwind.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private EmailVerificationService emailVerificationService;
	private MernisCheckService  mernisCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailVerificationService emailVerificationService,
			MernisCheckService mernisCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.emailVerificationService = emailVerificationService;
		this.mernisCheckService = mernisCheckService;
	}

	public Result candidateDao(String email) {
		if(this.candidateDao.findByEmail(email) == null) {
			return new SuccesResult();
					}
		return new ErrorResult();
	}
	
	public Result isIdentificationNumberExist(String identificationNumber) {
		 if(this.candidateDao.findByIdentificationNumber(identificationNumber) == null) {
			 return new SuccesResult();
		 }
		 return new ErrorResult();
	 }
	public Result isEmailExist(String email) {
		if((this.candidateDao.findByEmail(email) == null)) {
			return new SuccesResult();
		}
		return new ErrorResult();
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll()); 
	}

	@Override
	public Result add(Candidate candidate) {
		Result firstNameValid = FirstNameValidator.validation(candidate.getFirstName());
		Result lastNameValid = LastNameValidator.validation(candidate.getFirstName());
		Result emailValid = EmailValidator.validation(candidate.getFirstName());
		Result passwordValid = PasswordValidator.valid(candidate.getPassword(),candidate.getPassword());
		Result identificationNumberValid = IdentificationNumberValidator.valid(candidate.getIdentityNumber());
		Result dateOfBirthValid = DateOfBirthValidator.validation(candidate.getBirthYear());
		
		
		if(!firstNameValid.isSuccess()) {
			return new ErrorResult(firstNameValid.getMessage());
		}
		else if(!lastNameValid.isSuccess()) {
			return new ErrorResult(lastNameValid.getMessage());
		}
		else if(!emailValid.isSuccess()) {
			return new ErrorResult(emailValid.getMessage());
		}
		else if(!passwordValid.isSuccess()) {
			return new ErrorResult(passwordValid.getMessage()); 
		}
		else if(!identificationNumberValid.isSuccess()) {
			return new ErrorResult(identificationNumberValid.getMessage());
		}
		else if(!dateOfBirthValid.isSuccess()) {
			return new ErrorResult(dateOfBirthValid.getMessage());
		}
		else if(!this.emailVerificationService.verifyEmail(candidate.getEmail()).isSuccess()){
			return new ErrorResult("Email doğrulaması başarısız");
		}
		
		else if(!this.isEmailExist(candidate.getEmail()).isSuccess()) {
			return new ErrorResult("Mail adresi daha önce kullanılmıştır");
		}
		else if(!this.isIdentificationNumberExist(candidate.getEmail()).isSuccess()) {
			return new ErrorResult("T.C. Kimlik numarası daha önce kullanılmıştır.");
		}
		
		 
		this.candidateDao.save(candidate);
		return new SuccesResult("İş arayan sisteme eklendi.");
	}

}
