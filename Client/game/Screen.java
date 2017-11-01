import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

public class Screen extends JPanel {

	private static final long serialVersionUID = 1L;

	Canvas canvas = new Canvas();

	Screen() {
		setLayout(new BorderLayout());
		canvas.setBounds(0, 0, getWidth(), getHeight());
		add(canvas, BorderLayout.CENTER);
	}

	public void drawAll() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setColor(Color.RED);
		g.fillRect(0, 0, 200, 200);

		g.dispose();
		bs.show();
	}
}
