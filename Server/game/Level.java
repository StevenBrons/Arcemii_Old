import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

import tiles.Tile;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 10;
	int height = 10;

	Tile[][] tiles = new Tile[width][height];
	ArrayList<Entity> entities = new ArrayList<>();
	transient ArrayList<Player> players = new ArrayList<>();
	transient Update update = new Update();
	transient short IDCount = 0;
	
	String id;

	public Level() {
		byte[] bytes = new byte[24];
		new SecureRandom().nextBytes(bytes);
		id = new String(Base64.getEncoder().encode(bytes));
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}

	public void enter(Player player) {
		player.level = this;

		players.add(player);
		addEntity(player);
		
		player.client.output(this);
	}

	public void sendUpdate() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).output(update);
		}
	}

	public void addEntity(Entity e) {
		e.id = IDCount;
		IDCount++;
	}
	
	public void decodeInput(Entity e,byte[] bytes) {
		ByteBuffer bb = ByteBuffer.wrap(bytes);
		while (bb.hasRemaining()) {
			getEntity(bb.getShort()).abilities[bb.get() + 128].execute(bb);
		}		
	}
	
	public Entity getEntity(short id) {
		for (Entity e: entities) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public void input(Entity e, Update update) {
		decodeInput(e,update.data);
	}

}
