import java.util.ArrayList;

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

					long t = System.nanoTime();
					updateDungeons();
					sendUpdate();

					try {
						long i = (100 - ((System.nanoTime() - t) / 1000));
						Thread.sleep(i < 0 ? 0 : i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		t.start();
	}

	public void updateDungeons() {
		for (int i = 0; i < dungeons.size(); i++) {
			dungeons.get(i).update();
		}
	}

	public void sendUpdate() {
		for (int i = 0; i < dungeons.size(); i++) {
			dungeons.get(i).sendUpdate();
		}
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
