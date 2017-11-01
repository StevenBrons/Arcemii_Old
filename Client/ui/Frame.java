import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Screen screen = new Screen();

	public Frame() {
		setVisible(true);
		setSize(640, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		add(screen, BorderLayout.CENTER);
		
	}
	
}
