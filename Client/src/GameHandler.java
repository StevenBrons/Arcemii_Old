
public class GameHandler {

	public void start() {
		Thread draw = new Thread(new Runnable() {
			
			@Override
			public void run() {
					while(true) {
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
	
}
