package tiles;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int posx;
	public int posy;

	String texture;
	Color color;

	public Tile() {
		Random r = new Random();
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

	}

	public void drawTile() {

	}

}
