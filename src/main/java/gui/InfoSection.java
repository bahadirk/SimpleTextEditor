package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoSection extends JPanel {

	JLabel intAndRow;
	
	public InfoSection(){
		intAndRow = createLabel("Line 1, Column 1");
		this.add(intAndRow);
	}
	
	public void setText(String text){
		intAndRow.setText(text);
	}
	
	private JLabel createLabel(String text){
		JLabel label = new JLabel();
		label.setText(text);
		return label;
	}
}
