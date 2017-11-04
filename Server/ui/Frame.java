import java.awt.BorderLayout;

import javax.swing.JFrame;

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
		setLocationRelativeTo(null);
		setTitle("Server");
		add(list, BorderLayout.CENTER);
	}

}
