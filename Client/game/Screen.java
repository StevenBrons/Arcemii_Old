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

	public void drawAll() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		System.out.println("awef");
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setColor(Color.RED);
		g.fillRect(100, 100, 200, 200);

		g.dispose();
		bs.show();
	}
}
