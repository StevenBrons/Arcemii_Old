import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

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
		l.drawLevel(g);

		g.dispose();
		bs.show();
	}
}
