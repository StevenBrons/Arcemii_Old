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

	int red;
	int green;
	int blue;
	Color c;

	public Tile() {
		Random r = new Random();
		red = r.nextInt(255);
		green = r.nextInt(255);
		blue = r.nextInt(255);
		c = new Color(red, green, blue);

	}

	public void drawTile() {

	}

}
