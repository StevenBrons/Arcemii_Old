import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List list = new List();

	public Frame() {
		setVisible(true);
		setSize(640, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Server");
		add(list, BorderLayout.CENTER);
	}

}
