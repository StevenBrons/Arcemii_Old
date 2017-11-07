import java.security.SecureRandom;
import java.util.Base64;
import java.util.prefs.Preferences;

public class Main {

	public static final String REG_KEY = "archemii";
	public static LoginData userID;

	static GameHandler handler = new GameHandler();
	static Frame frame = new Frame();

	public static void main(String args[]) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		userID = getUserID();
		System.out.println(userID.getUserID());
		handler.output(userID);
		handler.start();
	}

	public static LoginData getUserID() {
		Preferences userPref = Preferences.userRoot();
		String id = userPref.get(REG_KEY, "");
		if (id.equals("")) {
			byte[] bytes = new byte[24];
			new SecureRandom().nextBytes(bytes);
			id = new String(Base64.getEncoder().encode(bytes));
			userPref.put(REG_KEY, id);
		}
		return new LoginData(id);
	}

}
