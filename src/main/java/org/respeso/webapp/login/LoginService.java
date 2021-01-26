package org.respeso.webapp.login;

/**
 * Log-in service class of the WebApp
 * @author Rodrigo Espeso
 *
 */
public class LoginService {
	
	/**
	 * Very basic validation. Only checks if the given user/pass matches with the hard-coded data
	 * @param user {@link String} typed user
	 * @param password {@link Stirng} typed pass
	 * @return {@code true} if validation is Ok, {@code false} elsewhere
	 */
	public boolean isUserValid(String user, String password) {
		return user.equals("rodrigo") && password.equals("1234");
	}
	
}
