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
	
	public void drawLevel(Graphics g) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				g.setColor(tiles[i][j].c);
				g.fillRect(tiles[i][j].posx * 10, tiles[i][j].posy * 10, 10, 10);
			}
		}
	}

}
