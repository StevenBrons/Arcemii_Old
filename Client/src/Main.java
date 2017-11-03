
public class Main {

	static GameHandler handler = new GameHandler();
	static Frame frame = new Frame();

	public static void main(String args[]) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		handler.output(new UserID("USERID"));
		handler.start();
	}

}
