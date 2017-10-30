
public class Main {

	static Connection connection = new Connection();

	public static void main(String args[]) {
		connection.send("USERDATA");
		new Frame();
	}

}
