
import entities.Entity;

class Player extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	transient Client client;
	String dungeonId;

	public Player(Client client, String id) {
		this.client = client;
	}

	public void changeLocation(Dungeon dungeon) {
		this.dungeonId = dungeon.id;
		dungeon.enter(this);
		client.output(dungeon);
	}

}