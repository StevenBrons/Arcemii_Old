
public class GameHandler {

	public Player player;
	public Dungeon level;
	public Connection connection = new Connection();
	
	

	public void start() {
		Thread draw = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						Main.frame.screen.drawAll(level);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		draw.start();
	}

	public void setLevel(Dungeon l) {
		this.level = l;
	}

	public void output(Object o) {
		connection.output(o);
	}
	
}
