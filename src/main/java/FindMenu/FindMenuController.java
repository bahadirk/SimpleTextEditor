package FindMenu;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import gui.TextArea;

public class FindMenuController {
	
	JMenu findMenu;
	TextArea textArea;
	FindMenuExecution findMenuExecution;
	FindMenuCommand find;
	
	public FindMenuController(JMenu findMenu, TextArea textArea){
		this.findMenu = findMenu;
		this.textArea = textArea;
		
		generateFindMenuExecutions(textArea);
		generateFindMenuHandlers();
	}
	
	private void generateFindMenuExecutions(TextArea textArea){
		this.findMenuExecution = new FindMenuExecution(textArea);
		find = new Find(findMenuExecution);
	}

	private void generateFindMenuHandlers(){
		pressFind();
	}
	
	private void pressFind(){
		JMenuItem findMenuItem = findMenu.getItem(0);
		
		Action findAction = new AbstractAction("Find"){
			public void actionPerformed(ActionEvent e) {
				find.execute();
			}
		};
		
		findAction.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		findMenuItem.setAction(findAction);
	}
}
