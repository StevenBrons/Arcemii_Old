import java.util.ArrayList;

public class GameHandler {

	boolean running = false;
	ArrayList<Player> players = new ArrayList<>();
	TestGenerator test = new TestGenerator();
	Level level;

	public GameHandler() {
		level = test.makeLevel(10, 10);
	}

	public void start() {
		if (running) {
			return;
		}
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (players.size() == 0) {
						running = false;
						break;
					}

				}
			}
		});
		t.start();
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

}
