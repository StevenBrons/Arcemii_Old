import java.io.IOException;

public class ServerMain {

	static Database database = new Database();
	static Game game = new Game();
	static Frame frame = new Frame();
	static Level level = new Level();

	public static void main(String[] args) {
		try {
			Server s = new Server();
			s.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
