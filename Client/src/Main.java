
public class Main {

	static Connection connection = new Connection();

	public static void main(String args[]) {
		new Frame();
		connection.send("USERDATA");
	}

}
