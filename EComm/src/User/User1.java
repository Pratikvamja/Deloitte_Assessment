package User;

public class User1 {

	private int loginId;
	private String password;
	private String email;
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User1(int loginId, String password, String email) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User1 [loginId=" + loginId + ", password=" + password + ", email=" + email + "]";
	}
	
}
