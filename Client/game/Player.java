public class Player extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	transient Ability walk = new Walk(this);
	
	public String id;
	String dungeonId;
	PlayerInputs inputs = new PlayerInputs();

	Player _this = this;
	
	Player() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				walk.invoke();
			}
		});
		t.start();
		
	}
}
