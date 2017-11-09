import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Console extends JTextPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
	SimpleAttributeSet linkStyle = new SimpleAttributeSet();

	OutputStream output = new OutputStream() {

		@Override
		public void write(int b) throws IOException {
			Exception e = new Exception();
			int i = e.getStackTrace().length;
			for (i--; i >= 0; i--) {
				if (e.getStackTrace()[i].getMethodName().equals("println")) {
					break;
				}
			}

			if (String.valueOf((char) b).equals("\n")) {
				try {
					getStyledDocument().insertString(getDocument().getLength(), "\t\t\t", defaultStyle);
					getStyledDocument().insertString(getDocument().getLength(), "" + e.getStackTrace()[i + 1],
							linkStyle);
				} catch (BadLocationException e2) {
					e2.printStackTrace();
				}
			}

			try {
				getStyledDocument().insertString(getDocument().getLength(), String.valueOf((char) b), defaultStyle);
			} catch (BadLocationException e2) {
				e2.printStackTrace();
			}

			setCaretPosition(getDocument().getLength());
		}
	};

	public Console() {
		StyleConstants.setForeground(defaultStyle, Color.BLACK);
		StyleConstants.setForeground(linkStyle, Color.GREEN);
		StyleConstants.setUnderline(linkStyle, true);
		StyleConstants.setItalic(linkStyle, true);

	}

}
