package gui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class ProgramMenuBar extends JMenuBar {
	
	public ProgramMenuBar(){
		
		JMenu fileMenu = createMenu("File");
		fileMenu.add(createMenuItem("Open", KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK)));
		fileMenu.add(createMenuItem("Save", KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK)));
		fileMenu.add(createMenuItem("SaveAs", null));
		fileMenu.add(createMenuItem("Exit", null));
		
		JMenu findMenu = createMenu("Find");
		findMenu.add(createMenuItem("Find", KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK)));
		
		
		this.add(fileMenu);
		this.add(findMenu);
	}
	
	private JMenu createMenu(String name){
		return new JMenu(name);
	}
	
	private JMenuItem createMenuItem(String name, KeyStroke keyStroke){
		JMenuItem menuItem = new JMenuItem(name);
		menuItem.setAccelerator(keyStroke);
		return menuItem;
	}
}
