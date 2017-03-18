package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TextAreaPanel extends JPanel{
	
	private RowPanel rowPanel;
	private TextArea textArea;
	
	public TextAreaPanel(){
		rowPanel = new RowPanel();
		textArea = new TextArea();
		
		//textArea.addCaretListener(rowPanel.getRowPanelCaretListener());
		setLayout(new GridLayout(1,2));
		add(rowPanel);
		add(new JScrollPane(textArea));
	}

	public TextArea getTextArea() {
		return textArea;
	}


}
