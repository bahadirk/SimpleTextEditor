package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{

	private final int WIDTH = 700;
	private final int HEIGHT = 700;
	
	private JPanel mainPanel;
	private ProgramMenuBar menuBar;
	private TextArea textArea;
	private InfoSection infoSection;

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
		textArea = new TextArea();
		infoSection = new InfoSection();
	}
	
	private void addComponents(){
		this.add(mainPanel);
		this.add(menuBar, BorderLayout.NORTH);
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
		this.add(infoSection, BorderLayout.SOUTH);
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
	
	public TextArea getTextArea() {
		return textArea;
	}

	public InfoSection getInfoSection() {
		return infoSection;
	}
	
	
}
