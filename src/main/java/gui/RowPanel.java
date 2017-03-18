package gui;

import java.awt.Color;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class RowPanel extends JTextArea implements CaretListener{
	
	public RowPanel(){
		setEditable(false);
		setBackground(new Color(193, 193, 193));
	}

	public void caretUpdate(CaretEvent e) {
		displaySelectionInfo(e.getDot(), (TextArea) e.getSource());
		
	}
	
	private void displaySelectionInfo(final int dot, final TextArea textArea) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				String row = getRow(dot, textArea);
				append(row + "\n");
				
				try {
					String content = getDocument().getText(0, getDocument().getLength());
					int lastLineBreak = content.lastIndexOf('\n');
					System.out.println(Integer.toString(lastLineBreak));
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	}
	
	public CaretListener getRowPanelCaretListener(){
		return (CaretListener) this;
	}
	
	private String getRow(int position, TextArea textArea) {
		int lineNumber = (position == 0) ? 1 : 0;
		try {
			int offs=position;
			while(offs>0) {
				offs=Utilities.getRowStart(textArea, offs)-1;
				lineNumber++;
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return Integer.toString(lineNumber);
	}

}
