import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Frame() {
		setVisible(true);
		setSize(640, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		add(new JLabel("Hier het spel maken Thijs"));
	}
	
}
