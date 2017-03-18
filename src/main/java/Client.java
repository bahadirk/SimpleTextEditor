import javax.swing.JMenu;

import FileMenu.FileMenuController;
import FindMenu.FindMenuController;
import gui.MainFrame;
import gui.ProgramMenuBar;
import gui.TextArea;

public class Client {
	
	public static void main(String[] agrs){
		
		MainFrame mainFrame = new MainFrame("Simple Text Editor");
		mainFrame.setVisible(true);

		ProgramMenuBar menuBar = mainFrame.getProgramMenuBar();
		JMenu fileMenu = menuBar.getMenu(0);
		JMenu findMenu = menuBar.getMenu(1);
		
		TextArea textArea = mainFrame.getTextAreaPanel().getTextArea();
		
		FileMenuController fileMenuController = new FileMenuController(fileMenu, textArea);
		FindMenuController findMenuController = new FindMenuController(findMenu, textArea);
	}

}
