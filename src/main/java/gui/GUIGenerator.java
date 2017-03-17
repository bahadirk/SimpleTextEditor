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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class GUIGenerator {

	private final int WIDTH = 700;
	private final int HEIGHT = 700;

	private JFrame mainFrame;
	private JMenuBar menuBar;
	private JEditorPane textArea;
	private JLabel intAndRowLabel;

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
		JMenuItem saveAs = new JMenuItem("Save As");
		JMenuItem exit = new JMenuItem("Exit");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		//		saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(saveAs);
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

		intAndRowLabel = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();

		panel.add(intAndRowLabel, FlowLayout.LEFT);
		panel.add(label2, FlowLayout.CENTER);
		panel.add(label3, FlowLayout.RIGHT);
		
		String line = getRow(1, textArea);
		String column = getColumn(-1, (JEditorPane) textArea);
		intAndRowLabel.setText("Line " + line + ", Column " + column);
		

		textArea.addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				String line = getRow(e.getDot(), (JEditorPane) e.getSource());
				String column = getColumn(e.getDot(), (JEditorPane) e.getSource());
				intAndRowLabel.setText("Line " + line + ", Column " + column);
			}
		});

		mainFrame.add(panel, BorderLayout.SOUTH);
	}

	public static String getRow(int position, JEditorPane editor) {
		int lineNumber = (position == 0) ? 1 : 0;
		try {
			int offs=position;
			while(offs>0) {
				offs=Utilities.getRowStart(editor, offs)-1;
				lineNumber++;
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return Integer.toString(lineNumber);
	}

	public static String getColumn(int pos, JEditorPane editor) {
		try {
			return Integer.toString(pos-Utilities.getRowStart(editor, pos)+1);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return Integer.toString(-1);
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
