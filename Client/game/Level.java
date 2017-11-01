import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import objects.GObject;
import tiles.Tile;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int width = 10;
	int height = 10;

	Tile[][] tiles = new Tile[width][height];
	ArrayList<GObject> object = new ArrayList<>();
	HashMap<String, Object> data = new HashMap<>();

	Level() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y] = new Tile();
			}
		}
	}

}
