
public class GameHandler {

	public Player player;

	public void start() {
		Thread draw = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						Main.f.screen.drawAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		draw.start();
	}

	public void setLevel(Level l) {

	}

	public void output(Object o) {
		Main.handler.player.output(o);
	}

}
