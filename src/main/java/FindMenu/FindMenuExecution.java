package FindMenu;

import javax.swing.JEditorPane;

public class FindMenuExecution {

	JEditorPane textArea;
	
	public FindMenuExecution(JEditorPane textArea){
		this.textArea = textArea;
	}
	
	public void find(){
		textArea.setText("Find");
	}
	
}
