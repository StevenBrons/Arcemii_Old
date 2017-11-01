
public class Main {

//	static Connection connection = new Connection();
	
	static Frame f = new Frame();

	public static void main(String args[]) {
//		connection.send("USERDATA");
		GameHandler handler = new GameHandler();
		handler.start();
	}

}
