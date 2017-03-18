package FileMenu;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import gui.TextArea;

public class FileMenuController {

	JMenu fileMenu;
	FileMenuCommand openFile;
	FileMenuCommand saveFile;
	FileMenuCommand exitFile;
	FileMenuCommand saveAsFile;
	FileMenuExecution fileMenuExecution;

	public FileMenuController(JMenu fileMenu, TextArea textArea){

		this.fileMenu = fileMenu;

		generateFileMenuExecutions(textArea);
		generateFileMenuHandlers();

	}

	private void generateFileMenuExecutions(TextArea textArea){
		this.fileMenuExecution = new FileMenuExecution(textArea);	
		openFile = new OpenFile(fileMenuExecution);
		saveFile = new SaveFile(fileMenuExecution);
		saveAsFile = new SaveAsFile(fileMenuExecution);
		exitFile = new ExitFile(fileMenuExecution);
	}

	private void generateFileMenuHandlers(){
		pressOpenFile();
		pressSaveFile();
		pressSaveAsFile();
		pressExitFile();
	}

	private void pressOpenFile(){
		JMenuItem openFileMenuItem = fileMenu.getItem(0);

		Action openAction = new AbstractAction("Open"){
			public void actionPerformed(ActionEvent e) {
				openFile.execute();
			}
		};

		openAction.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		openFileMenuItem.setAction(openAction);

	}

	private void pressSaveFile(){
		JMenuItem saveFileMenuItem = fileMenu.getItem(1);

		Action saveAction = new AbstractAction("Save") {

			public void actionPerformed(ActionEvent e) {
				saveFile.execute();
			}
		};

		saveAction.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		saveFileMenuItem.setAction(saveAction);

	}

	private void pressSaveAsFile(){
		JMenuItem saveAsFileMenuItem = fileMenu.getItem(2);
		
		Action saveAsAction = new AbstractAction("Save As") {

			public void actionPerformed(ActionEvent e) {
				saveFile.execute();
			}
		};

		//saveAsAction.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() | KeyEvent.SHIFT_DOWN_MASK));
		saveAsFileMenuItem.setAction(saveAsAction);

	}

	private void pressExitFile(){
		JMenuItem exitFileMenuItem = fileMenu.getItem(3);

		Action saveAction = new AbstractAction("Exit") {

			public void actionPerformed(ActionEvent e) {
				exitFile.execute();
			}
		};

		exitFileMenuItem.setAction(saveAction);
	}


}
