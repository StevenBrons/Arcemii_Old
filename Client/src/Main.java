
public class Main {

	static Connection connection = new Connection();
	static GameHandler handler = new GameHandler();
	static Frame f = new Frame();

	public static void main(String args[]) {
		handler.output("USERDATA");
		handler.start();
	}

}
