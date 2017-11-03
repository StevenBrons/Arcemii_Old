import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	private ObjectInputStream in;
	private ObjectOutputStream out;

	public Client(Socket socket) {
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
		ServerMain.game.start();
	}

	public void input(Object o) {
		ServerMain.frame.list.add(o.getClass().getName());
		switch (o.getClass().getName()) {
		case "UserID":
			output(ServerMain.game.level);
			break;
		default:
			ServerMain.frame.list.add(o.getClass().getName());
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
