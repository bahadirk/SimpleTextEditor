package gui;

import java.awt.Rectangle;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class TextArea extends JEditorPane {

	JLabel label;
	
	public TextArea(){
		this.setEditable(true);
	}
	
	public JEditorPane getTextArea(){
		return this;
	}
	
}

