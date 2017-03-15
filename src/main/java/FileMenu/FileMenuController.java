package FileMenu;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class FileMenuController {

	FileMenuExecution fileMenuExecution;
	JMenu fileMenu;
	FileMenuCommand openFile;
	FileMenuCommand saveFile;
	FileMenuCommand exitFile;

	public FileMenuController(JMenu fileMenu, JEditorPane textArea){
		
		this.fileMenu = fileMenu;
			
		generateFileMenuExecutions(textArea);
		generateFileMenuHandlers();
		
	}
	
	private void generateFileMenuExecutions(JEditorPane textArea){
		this.fileMenuExecution = new FileMenuExecution(textArea);	
		openFile = new OpenFile(fileMenuExecution);
		saveFile = new SaveFile(fileMenuExecution);
		exitFile = new ExitFile(fileMenuExecution);
	}
	
	private void generateFileMenuHandlers(){
		pressOpenFile();
		pressSaveFile();
		pressExitFile();
	}

	private void pressOpenFile(){
		JMenuItem openFileMenuItem = fileMenu.getItem(0);
		
		Action openAction = new AbstractAction("Open"){
			public void actionPerformed(ActionEvent e) {
				openFile.execute();
			}
		};
		
		openAction.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		openFileMenuItem.setAction(openAction);

	}

	private void pressSaveFile(){
		JMenuItem saveFileMenuItem = fileMenu.getItem(1);
		
		Action saveAction = new AbstractAction("Save") {
			 
		    public void actionPerformed(ActionEvent e) {
		    	saveFile.execute();
		    }
		};
		
		saveAction.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		saveFileMenuItem.setAction(saveAction);
		
	}
	
	private void pressExitFile(){
		JMenuItem exitFileMenuItem = fileMenu.getItem(2);
		
		Action saveAction = new AbstractAction("Exit") {
			 
		    public void actionPerformed(ActionEvent e) {
		    	exitFile.execute();
		    }
		};
		
		exitFileMenuItem.setAction(saveAction);
	}

}
