package FileMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class FileMenuController {

	FileMenuExecution fileMenuExecution;
	JMenu fileMenu;
	FileMenuCommand openFile;
	FileMenuCommand saveFile;

	public FileMenuController(JMenu fileMenu, JEditorPane textArea){
		
		this.fileMenu = fileMenu;
			
		generateFileMenuExecutions(textArea);
		generateFileMenuHandlers();
		
	}
	
	private void generateFileMenuExecutions(JEditorPane textArea){
		this.fileMenuExecution = new FileMenuExecution(textArea);	
		openFile = new OpenFile(fileMenuExecution);
		saveFile = new SaveFile(fileMenuExecution);
	}
	
	private void generateFileMenuHandlers(){
		pressOpenFile();
		pressSaveFile();
	}

	private void pressOpenFile(){
		JMenuItem openFileMenuItem = fileMenu.getItem(0);

		openFileMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile.execute();
			}
		});

	}

	private void pressSaveFile(){
		JMenuItem saveFileMenuItem = fileMenu.getItem(1);

		saveFileMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile.execute();
			}
		});
		
	}

}
