import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Player {

	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Socket socket;

	public Player(Socket socket) {
		this.socket = socket;
		try {
			this.in = new ObjectInputStream(socket.getInputStream());
			this.out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					input(in.readObject());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

	public void input(Object o) {
		ServerMain.frame.list.add(o.getClass().getName());
		switch (o.getClass().getName()) {
		case "java.lang.String":
			output(ServerMain.level);
			break;
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
