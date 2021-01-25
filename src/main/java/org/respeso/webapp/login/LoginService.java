package org.respeso.webapp.login;

public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		return user.equals("rodrigo") && password.equals("1234");
	}
	
}
