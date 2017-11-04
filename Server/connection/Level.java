import java.io.Serializable;
import java.util.ArrayList;

import objects.Obj;
import tiles.Tile;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int width = 10;
	int height = 10;
	
	Tile[][] tiles = new Tile[width][height];
	ArrayList<Obj> object = new ArrayList<>();

	Level() {
		System.out.println("Level gemaakt");
	}
	
}
