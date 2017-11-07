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
				while (true) {
					try {
						input(in.readObject());
					} catch (IOException e) {
						try {
							in.close();
							out.close();
							socket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						break;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		ServerMain.game.start();
	}

	public void input(Object o) {
		ServerMain.log(o.getClass().getName());
		switch (o.getClass().getName()) {
		case "LoginData":
			LoginData loginData = (LoginData) o;
			Player player = new Player(this, loginData.getUserID());
			ServerMain.game.addPlayer(player);
			player.changeLocation(ServerMain.game.getDungeon("LOBBY1"));
			break;
		default:
			ServerMain.log("Unknown input class type: " + o.getClass().getName());
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
