import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ServerMain {

	static Database database = new Database();
	static GameHandler game = new GameHandler();
	static Frame frame = new Frame();

	public static void main(String[] args) {
		Server s = new Server();
		s.start();

		System.setOut(new PrintStream(frame.console.output));
	}

}
