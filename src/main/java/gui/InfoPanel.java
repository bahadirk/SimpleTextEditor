package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class InfoPanel extends JPanel {

	static final int LOGGER = 15;

	JLabel rowAndColLabel;
	CaretListener rowAndColLabelListener;

	public InfoPanel() {
		rowAndColLabel = new RowAndColLabel("Line 1, Column 1");
		rowAndColLabelListener = (CaretListener) rowAndColLabel;
		add(rowAndColLabel);
	}

	public CaretListener getRowAndColLabelListener() {
		return (CaretListener) rowAndColLabel;
	}
}

class RowAndColLabel extends JLabel implements CaretListener {
	public RowAndColLabel(String label) {
		super(label);
	}

	// Might not be invoked from the event dispatching thread.
	public void caretUpdate(CaretEvent e) {
		displaySelectionInfo(e.getDot(), (TextArea) e.getSource());
	}

	protected void displaySelectionInfo(final int dot, final TextArea textArea) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				String row = Integer.toString(textArea.getLineCount());
				String column = getColumn(dot, textArea);
				setText("Line: " + row + " Column: " + column);
			}
		});
	}

	private String getColumn(int pos, TextArea textArea) {
		try {
			return Integer.toString(pos - Utilities.getRowStart(textArea, pos) + 1);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return Integer.toString(-1);
	}
}