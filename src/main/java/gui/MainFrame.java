package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	private final int WIDTH = 700;
	private final int HEIGHT = 700;
	
	private JPanel mainPanel;
	private ProgramMenuBar menuBar;
	private InfoPanel infoPanel;
	private TextAreaPanel textAreaPanel;

	public MainFrame(String name){
		this.setName(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		createOtherGuiComponents();
		addComponents();
	}
	
	private void createOtherGuiComponents(){
		mainPanel = new JPanel(new BorderLayout());
		menuBar = new ProgramMenuBar();
		infoPanel = new InfoPanel();
		textAreaPanel = new TextAreaPanel();
	}
	
	private void addComponents(){
		this.add(mainPanel);
		this.add(menuBar, BorderLayout.NORTH);
		this.add(textAreaPanel, BorderLayout.CENTER);
		this.add(infoPanel, BorderLayout.SOUTH);
			
		textAreaPanel.getTextArea().addCaretListener(infoPanel.getRowAndColLabelListener());
		
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public ProgramMenuBar getProgramMenuBar(){
		return menuBar;
	}

	public TextAreaPanel getTextAreaPanel() {
		return textAreaPanel;
	}
	
}
