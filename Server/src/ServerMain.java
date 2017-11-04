public class ServerMain {

	static Database database = new Database();
	static GameHandler game = new GameHandler();
	static Frame frame = new Frame();

	public static void main(String[] args) {
		Server s = new Server();
		s.start();
		log("hoi");
		log("hoi");
		log("hoi");
		log("hoi");
		log("hoi");

	}

	public static void log(String s) {
		frame.list.log(s);
	}

}
