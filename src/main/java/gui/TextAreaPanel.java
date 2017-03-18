package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TextAreaPanel extends JPanel{
	
	private LineArea lineArea;
	private TextArea textArea;
	
	public TextAreaPanel(){
		lineArea = new LineArea();
		textArea = new TextArea();
		
		textArea.addCaretListener(lineArea.getRowPanelCaretListener());
		setLayout(new GridLayout(1,2));
		add(new JScrollPane(lineArea));
		add(new JScrollPane(textArea));
	}

	public TextArea getTextArea() {
		return textArea;
	}


}
