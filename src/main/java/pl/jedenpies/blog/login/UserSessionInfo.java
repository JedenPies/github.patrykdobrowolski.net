package pl.jedenpies.blog.login;

public class UserSessionInfo {

	private String email;

	public boolean isUserLoggedIn() {
		return email != null;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
