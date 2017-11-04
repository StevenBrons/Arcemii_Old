import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas {

	private static final long serialVersionUID = 1L;

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
		drawLevel(g, l);

		g.drawImage(ResLoader.getTexture("t1"), 19, 19, null);

		g.dispose();
		bs.show();
	}

	public void drawLevel(Graphics2D g, Level l) {
		for (int i = 0; i < l.tiles.length; i++) {
			for (int j = 0; j < l.tiles[i].length; j++) {
				g.setColor(l.tiles[i][j].c);
				g.fillRect(l.tiles[i][j].posx * 10, l.tiles[i][j].posy * 10, 10, 10);
			}
		}
	}
}
