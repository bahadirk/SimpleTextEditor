package gui;

import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class TextArea extends JEditorPane {

	JLabel label;
	
	public TextArea(){
		this.setEditable(true);
	}
	
	public JEditorPane getTextArea(){
		return this;
	}
	
}

