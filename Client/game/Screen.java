import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas {

	private static final long serialVersionUID = 1L;

	int tileWidth = 64;
	
	Screen() {
		setBackground(Color.WHITE);
	}

	public void drawAll(Level l) {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		if (l == null) {
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.clearRect(0, 0, getWidth(), getHeight());
		drawLevel(g, l);
		//g.drawImage(ResLoader.getTexture("t1"), 19, 19, null);

		g.dispose();
		bs.show();
	}

	public void drawLevel(Graphics2D g, Level l) {
		for (int i = 0; i < l.tiles.length; i++) {
			for (int j = 0; j < l.tiles[i].length; j++) {
				g.setColor(l.tiles[i][j].color);
				g.fillRect(l.tiles[i][j].posx * tileWidth, l.tiles[i][j].posy * tileWidth, tileWidth, tileWidth);
			}
		}
	}
}
