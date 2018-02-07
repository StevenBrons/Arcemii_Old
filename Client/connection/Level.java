import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;

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
	Player player;
	
	String id;
	transient Update update = new Update();
	
	public void input(Update update) {
		decodeInput(update.data);
	}
	
	public void decodeInput(byte[] bytes) {
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

}
