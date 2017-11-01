import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int SERVER_PORT = 26194;

	ServerSocket serverSocket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(SERVER_PORT);
	}

	public void runServer() {
		System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				Player c = new Player(socket);
				ServerMain.game.handler.addPlayer(c);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void start() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				runServer();
			}
		});
		t.start();
	}

}
