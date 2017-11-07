import java.io.Serializable;
import java.util.ArrayList;

import entities.Entity;
import objects.Obj;
import tiles.Tile;

public class Dungeon implements Serializable {

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

	Dungeon() {

	}

}
