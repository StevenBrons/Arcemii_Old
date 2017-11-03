import java.io.Serializable;

class UserID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userID;

	public UserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}
}
