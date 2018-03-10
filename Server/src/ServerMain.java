import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class ServerMain {

	static Database database = new Database();
	static GameHandler game = new GameHandler();
	static Frame frame = new Frame();

	public static void main(String[] args) {
		Server s = new Server();
		s.start();
		
		System.setErr(new PrintStream(frame.console.output));
		System.setOut(new PrintStream(frame.console.output));
	}

	public static int sizeof(Object obj) throws IOException {

		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);

		objectOutputStream.writeObject(obj);
		objectOutputStream.flush();
		objectOutputStream.close();

		return byteOutputStream.toByteArray().length;
	}

}
