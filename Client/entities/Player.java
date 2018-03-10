public class Player extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Ability[] abilities = new Ability[]{new UserIdentify(this),new Walk(this)}; 
	
	String id;
	String dungeonId;
	PlayerInputs inputs = new PlayerInputs();

	Player _this = this;
	
	Player() {
	}
}
