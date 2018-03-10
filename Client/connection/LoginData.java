import java.io.Serializable;

class LoginData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userID;

	public LoginData(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}
}
