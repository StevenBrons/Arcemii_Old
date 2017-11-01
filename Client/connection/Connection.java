import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {

	public static final String SERVER_NAME = "localhost";
	public static final int SERVER_PORT = 26194;

	public Connection() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Connecting to " + SERVER_NAME + " on port " + SERVER_PORT);
					@SuppressWarnings("resource")
					Socket client = new Socket(SERVER_NAME, SERVER_PORT);
					System.out.println("Just connected to " + client.getRemoteSocketAddress());
					Main.handler.player = new Player(new ObjectOutputStream(client.getOutputStream()));

					Thread t = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Main.handler.player.input(new ObjectInputStream(client.getInputStream()).readObject());
							} catch (ClassNotFoundException | IOException e) {
								e.printStackTrace();
							}
						}
					});
					t.start();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

}
