import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int SERVER_PORT = 26194;

	ServerSocket serverSocket;

	public Server() {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runServer() {
		System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				new Client(socket);
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
