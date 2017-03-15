import javax.swing.JMenu;
import javax.swing.JTextArea;

import FileMenu.FileMenuController;
import gui.GUIGenerator;

public class Client {
	
	public static void main(String[] agrs){
		GUIGenerator gui = new GUIGenerator("Simple Text Editor");
		
		JTextArea textArea = gui.getTextArea();
		JMenu fileMenu = gui.getMenuBar().getMenu(0);
		
		FileMenuController fileMenuController = new FileMenuController(fileMenu, textArea);
	}

}
