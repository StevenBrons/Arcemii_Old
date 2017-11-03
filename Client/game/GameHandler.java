
public class GameHandler {

	public Player player;
	public Connection connection = new Connection();;

	public void start() {
		Thread draw = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						Main.frame.screen.drawAll();
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
		connection.output(o);
	}

}
