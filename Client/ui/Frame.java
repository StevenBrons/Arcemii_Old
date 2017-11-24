import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	Screen screen = new Screen();

	public Frame() {
		setVisible(true);
		setSize(640, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());

//		screen.addKeyListener(Main.handler.player.inputs.keyListener);
//		screen.addMouseListener(Main.handler.player.inputs.mouseListener);

		add(screen, BorderLayout.CENTER);

	}

}
