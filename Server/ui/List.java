import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class List extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int count = 0;
	String columnNames[] = { "Message" };
	String rowData[][] = { { "test" } };
	TableModel model = new DefaultTableModel(rowData, columnNames);
	JTable table = new JTable(model);

	public List() {
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
	}

	void log(String s) {
		String newRowData[][] = new String[rowData.length + 1][1];
		for (int i = 0; i < rowData.length; i++) {
			newRowData[i] = rowData[i];
		}
		newRowData[rowData.length - 1] = new String[] { s };
		rowData = newRowData;
		model = new DefaultTableModel(rowData, columnNames);
		table.setModel(model);
	}

}
