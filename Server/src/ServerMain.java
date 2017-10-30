import java.io.IOException;

public class ServerMain {

	public static void main(String[] args) {
		try {
			Server s = new Server();
			s.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Frame();
	}

}
