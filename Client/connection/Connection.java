import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {

	public static final String SERVER_NAME = "localhost";
	public static final int SERVER_PORT = 26194;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Connection() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Connecting to " + SERVER_NAME + " on port " + SERVER_PORT);
					@SuppressWarnings("resource")
					Socket client = new Socket(SERVER_NAME, SERVER_PORT);
					System.out.println("Just connected to " + client.getRemoteSocketAddress());

					while (true) {
						try {
							input(in.readObject());
						} catch (ClassNotFoundException | IOException e) {
							e.printStackTrace();
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

	public void input(Object o) {
		switch (o.getClass().getName()) {
		default:
			System.err.println(o.getClass().getName());
			break;
		}
	}

	public void output(Object o) {
		try {
			out.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
