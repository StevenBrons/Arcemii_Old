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
	
	int x = 10;

	Tile[][] tiles = new Tile[width][height];
	ArrayList<Obj> object = new ArrayList<>();

	Level() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y] = new Tile();
			}
		}
	}

}
