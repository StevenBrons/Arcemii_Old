import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.swing.ButtonGroup;

public class Client {

	private ObjectInputStream in;
	private ObjectOutputStream out;
	private String userID;

	Player player = null;

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
		switch (o.getClass().getName()) {
		case "LoginData":
			LoginData loginData = (LoginData) o;
			userID = loginData.getUserID();
			break;
		case "Join":
			Join join = (Join) o;
			player = new Player(this, userID);
			ServerMain.game.getLevel(join.levelID).enter(player);
			ServerMain.game.start();
		    ByteBuffer buffer = ByteBuffer.allocate(2);
		    buffer.putShort(player.id);
			output(new Update(new byte[] {buffer.get(0),buffer.get(1),1}));
			break;
		case "Update":
			Update update = (Update) o;
			player.level.input(player, update);
			break;
		default:
			System.out.println("Unknown input class type: " + o.getClass().getName());
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
