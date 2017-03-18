package gui;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class InfoPanel extends JPanel{
	
	JLabel rowAndColLabel;
	CaretListener rowAndColLabelListener;
	
	public InfoPanel(){
		rowAndColLabel = new RowAndColLabel("Line 1, Column 1");
		rowAndColLabelListener = (CaretListener) rowAndColLabel;
		add(rowAndColLabel);
	}
	
	public CaretListener getRowAndColLabelListener(){
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
				String row = getRow(dot, textArea);
				String column = getColumn(dot, textArea);
				setText("Line: " + row + " Column: " + column);
			}
		});
	}
	
	private String getRow(int position, JEditorPane editor) {
		int lineNumber = (position == 0) ? 1 : 0;
		try {
			int offs=position;
			while(offs>0) {
				offs=Utilities.getRowStart(editor, offs)-1;
				lineNumber++;
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return Integer.toString(lineNumber);
	}

	private String getColumn(int pos, JEditorPane editor) {
		try {
			return Integer.toString(pos-Utilities.getRowStart(editor, pos)+1);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return Integer.toString(-1);
	}
}