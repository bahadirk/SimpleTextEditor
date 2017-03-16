import javax.swing.JEditorPane;
import javax.swing.JMenu;

import FileMenu.FileMenuController;
import FindMenu.FindMenuController;
import gui.GUIGenerator;

public class Client {
	
	public static void main(String[] agrs){
		GUIGenerator gui = new GUIGenerator("Simple Text Editor");
		
		JEditorPane textArea = gui.getTextArea();
		JMenu fileMenu = gui.getMenuBar().getMenu(0);
		JMenu findMenu = gui.getMenuBar().getMenu(1);
		
		FileMenuController fileMenuController = new FileMenuController(fileMenu, textArea);
		FindMenuController findMenuController = new FindMenuController(findMenu, textArea);
	}

}
