package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class GUIGenerator {

	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	
	private JFrame mainFrame;
	private JMenuBar menuBar;
	private JEditorPane textArea;

	public GUIGenerator(String name){
		createMainFrame(name);
		createMainPanel();
		createMenu();
		createTextArea();
		createInfoSection();
		mainFrame.setVisible(true);
	}

	private void createMainFrame(String name){
		mainFrame = new JFrame(name);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, 
				dim.height/2-mainFrame.getSize().height/2);
	}

	private void createMainPanel(){
		JPanel panel = new JPanel(new BorderLayout());
		mainFrame.add(panel);
	}

	private void createMenu(){
		menuBar = new JMenuBar();

		//Menu Sections
		JMenu fileMenu = new JMenu("File");
		JMenu findMenu = new JMenu("Find");
		menuBar.add(fileMenu);
		menuBar.add(findMenu);

		//File Menu Items
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(exit);
		
		
		//Find Menu Items
		JMenuItem find = new JMenuItem("Find");
		find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
		findMenu.add(find);

		mainFrame.add(menuBar, BorderLayout.NORTH);
	}

	private void createTextArea(){
		textArea = new JEditorPane();
		textArea.setEditable(true);
		mainFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	private void createInfoSection(){
		
		JPanel panel = new JPanel(new FlowLayout());
		
		JLabel label1 = new JLabel("");
		JLabel label2 = new JLabel("");
		JLabel label3 = new JLabel("");
		
		panel.add(label1, FlowLayout.LEFT);
		panel.add(label2, FlowLayout.CENTER);
		panel.add(label3, FlowLayout.RIGHT);
		
		mainFrame.add(panel, BorderLayout.SOUTH);
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JEditorPane getTextArea() {
		return textArea;
	}
	
	

}
