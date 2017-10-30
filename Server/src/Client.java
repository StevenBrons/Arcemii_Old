import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

	ObjectInputStream input;
	ObjectOutputStream output;

	public Client(InputStream input, OutputStream output) {
		System.out.println("New client joined");
		try {
			this.input = new ObjectInputStream(input);
			this.output = new ObjectOutputStream(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
