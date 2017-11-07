import java.util.ArrayList;
import java.util.logging.Level;

public class GameHandler {

	boolean running = false;
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Dungeon> dungeons = new ArrayList<>();

	DungeonCreator dungeonLoader = new DungeonCreator();

	public GameHandler() {
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

	public Dungeon getDungeon(String id) {
		for (Dungeon dungeon : dungeons) {
			dungeon.id.equals(id);
			return dungeon;
		}
		return dungeonLoader.createDungeon(id);
	}

}
