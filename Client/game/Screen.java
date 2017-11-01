import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

public class Screen extends JPanel {

	private static final long serialVersionUID = 1L;

	Canvas c;

	Screen() {
		setLayout(new BorderLayout());
		c = new Canvas();
		c.setBounds(0, 0, getWidth(), getHeight());
		add(c, BorderLayout.CENTER);
	}

	public void drawAll() {
		BufferStrategy bs = c.getBufferStrategy();
		if (bs == null) {
			c.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setColor(Color.RED);
		g.fillRect(0, 0, 200, 200);
		System.out.println("ewaf");

		g.dispose();
		bs.show();
		bs.dispose();
	}
}
