import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import objects.Obj;
import tiles.Tile;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int width;
	int height;
	
	int x;

	Tile[][] tiles;
	ArrayList<Obj> object;

	Level() {
		
	}
	
}
