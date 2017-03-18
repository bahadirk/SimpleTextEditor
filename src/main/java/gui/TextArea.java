package gui;

import javax.swing.JEditorPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class TextArea extends JEditorPane {
	
	InfoSection infoSection;
	
	public TextArea(){
		this.infoSection = new InfoSection();
		this.setEditable(true);	
		
		this.addCaretListener(new CaretListener() {
			
			public void caretUpdate(CaretEvent e) {
				String line = getRow(e.getDot(), (TextArea) e.getSource());
				String column = getColumn(e.getDot(), (TextArea) e.getSource());
				infoSection.setText("Line " + line + ", Column " + column);
			}
		});
	}
	
	public TextArea getTextArea(){
		return this;
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
