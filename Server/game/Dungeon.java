import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

import entities.Entity;
import objects.Obj;
import tiles.Tile;

public class Dungeon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 10;
	int height = 10;

	Tile[][] tiles = new Tile[width][height];
	ArrayList<Obj> objects = new ArrayList<>();
	ArrayList<Entity> entities = new ArrayList<>();

	String id;

	public Dungeon() {
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
		entities.add(player);
	}

}
