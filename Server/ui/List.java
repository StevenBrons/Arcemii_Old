import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class List extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int count = 0;
	GridBagConstraints gb = new GridBagConstraints();

	public List() {
		setLayout(new GridBagLayout());
		gb.gridx = 0;
		gb.gridy = 0;
	}

	void add(String s) {
		add(new JLabel(s), gb);
		validate();
	}

}
