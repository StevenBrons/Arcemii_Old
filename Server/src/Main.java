import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			Server s = new Server();
			s.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
