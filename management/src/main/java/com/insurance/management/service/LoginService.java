package com.insurance.management.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.management.repository.LoginRepository;
import com.insurance.management.model.AuthenticationStatus;
import com.insurance.management.model.Login;
@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	public AuthenticationStatus validateLogin(String userName, String password) {
		AuthenticationStatus status = null;
		Login login = loginRepository.validateLogin(userName, password);
		if(login!=null) {
			status = new AuthenticationStatus(login.getUserName(), login.getPassword(), true);
		}
		else {
			status = new AuthenticationStatus(null, null, false);
		}
		return status;
	}
	
}