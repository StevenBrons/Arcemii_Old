
import java.io.IOException;

import entities.Entity;

class Player extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	transient Client client;
	String dungeonId;

	boolean UP = false;
	boolean DOWN = false;
	boolean LEFT = false;
	boolean RIGHT = false;

	public Player(Client client, String id) {
		this.client = client;
	}

	public void changeLocation(Dungeon dungeon) {
		this.dungeonId = dungeon.id;
		dungeon.enter(this);

		try {
			System.out.println(ServerMain.sizeof(dungeon));
		} catch (IOException e) {
			e.printStackTrace();
		}

		client.output(dungeon);
	}

	public void output(Object o) {
		client.output(o);
	}

	public void update() {
	}

}