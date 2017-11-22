package tiles;


import java.awt.Color;
import java.io.Serializable;

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
	public Color c;

	public Tile() {
	}

	public void drawTile() {

	}

}
