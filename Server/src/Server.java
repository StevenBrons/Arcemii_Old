import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class Server {

	public static final int SERVER_PORT = 26194;

	ArrayList<Client> clients = new ArrayList<>();
	ServerSocket serverSocket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(SERVER_PORT);
	}

	public void runServer() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket socket = serverSocket.accept();

				Client c = new Client(socket);
				clients.add(c);
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (SocketException e) {
				System.out.println("Connection lost");
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
