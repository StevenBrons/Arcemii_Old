import java.util.ArrayList;

public class GameHandler {

	boolean running = false;
	ArrayList<Level> levels = new ArrayList<>();

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
					if (levels.size() == 0) {
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
		for (int i = 0; i < levels.size(); i++) {
			levels.get(i).update();
		}
	}

	public void sendUpdate() {
		for (int i = 0; i < levels.size(); i++) {
			levels.get(i).sendUpdate();
		}
	}

	public Level getLevel(String id) {
		for (Level level : levels) {
			System.out.println(id);
			System.out.println(level.id);
			if (level.id.equals(id)) {
				System.out.println("asdf");
				return level;
			}
		}
		
		Level level = dungeonLoader.createDungeon(id);
		levels.add(level);
		return level; 
	}

}
