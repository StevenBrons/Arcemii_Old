import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {

	public static final String SERVER_NAME = "localhost";
	public static final int SERVER_PORT = 26194;

	public ObjectOutputStream output;
	public ObjectInputStream input;

	public Connection() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Connecting to " + SERVER_NAME + " on port " + SERVER_PORT);
					@SuppressWarnings("resource")
					Socket client = new Socket(SERVER_NAME, SERVER_PORT);

					System.out.println("Just connected to " + client.getRemoteSocketAddress());
					output = new ObjectOutputStream(client.getOutputStream());
					input = new ObjectInputStream(client.getInputStream());
					output.writeObject("Test");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

	public void send(Object o) {
		 try {
		 output.writeObject(o);
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
	}

}
