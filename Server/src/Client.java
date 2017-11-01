import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

	ObjectInputStream input;
	ObjectOutputStream output;

	Socket socket;

	public Client(Socket socket) {
		System.out.println("New client joined");
		this.socket = socket;
		try {
			this.input = new ObjectInputStream(socket.getInputStream());
			this.output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					String o = (String) input.readObject();
					System.out.println(o);
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

}
