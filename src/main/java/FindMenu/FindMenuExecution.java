package FindMenu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FindMenuExecution {

	JEditorPane textArea;

	public FindMenuExecution(JEditorPane textArea){
		this.textArea = textArea;
	}

	public void find(){
		JFrame findWindow = new JFrame("Find");
		findWindow.setSize(350, 500);
		findWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		findWindow.setLocation(findWindow.getSize().width/4, findWindow.getSize().height);

		JPanel mainFindPanel = new JPanel();
		mainFindPanel.setLayout(new GridLayout(5, 1));

		JPanel findReplacePanel = new JPanel();
		findReplacePanel.setLayout(new GridLayout(2,1));
		findReplacePanel.setBorder(new EmptyBorder(10,10,10,10));


		JLabel findLabel = new JLabel("Find:");
		JLabel replaceLabel = new JLabel("Replace With:");

		JTextArea findTextArea = new JTextArea(5,10);
		JTextArea replaceTextArea = new JTextArea(5,10);


		findReplacePanel.add(findLabel);
		findReplacePanel.add(findTextArea);
		findReplacePanel.add(replaceLabel);
		findReplacePanel.add(replaceTextArea);


		JPanel directionPanel = new JPanel();
		directionPanel.setBorder(new EmptyBorder(10,10,10,10));
		TitledBorder directionTitle = new TitledBorder("Direction");
		directionTitle.setTitleJustification(TitledBorder.CENTER);
		directionTitle.setTitlePosition(TitledBorder.TOP);
		directionPanel.setBorder(directionTitle);
		JRadioButton forward = new JRadioButton("Forward");
		JRadioButton backward = new JRadioButton("Backward");
		ButtonGroup directionGroup = new ButtonGroup();
		directionGroup.add(forward);
		directionGroup.add(backward);
		directionPanel.add(forward);
		directionPanel.add(backward);

		JPanel scopePanel = new JPanel();
		TitledBorder scopeTitle = new TitledBorder("Scope");
		scopeTitle.setTitleJustification(TitledBorder.CENTER);
		scopeTitle.setTitlePosition(TitledBorder.TOP);
		scopePanel.setBorder(scopeTitle);
		JRadioButton all = new JRadioButton("All");
		JRadioButton selectedItems = new JRadioButton("Selected Items");
		ButtonGroup scopeGroup = new ButtonGroup();
		scopeGroup.add(all);
		scopeGroup.add(selectedItems);
		scopePanel.add(all);
		scopePanel.add(selectedItems);
		
		
		JPanel optionPanel = new JPanel();
		TitledBorder optionTitle = new TitledBorder("Option");
		optionTitle.setTitleJustification(TitledBorder.CENTER);
		optionTitle.setTitlePosition(TitledBorder.TOP);
		optionPanel.setBorder(optionTitle);
		JCheckBox caseSensitive = new JCheckBox("Case Sensitive");
		JCheckBox wrapSearch = new JCheckBox("Wrap Search");
		optionPanel.add(caseSensitive);
		optionPanel.add(wrapSearch);
		
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new EmptyBorder(10,10,10,10));
		JButton findButton = new JButton("Find");
		JButton findReplaceButton = new JButton("Find/Replace Button");
		buttonsPanel.add(findButton);
		buttonsPanel.add(findReplaceButton);
		
		JPanel directionAndScopePanel = new JPanel();
		directionAndScopePanel.setLayout(new GridLayout(1,2));
		directionAndScopePanel.add(directionPanel);
		directionAndScopePanel.add(scopePanel);

		mainFindPanel.add(findReplacePanel);
		mainFindPanel.add(directionAndScopePanel);
		mainFindPanel.add(optionPanel);
		mainFindPanel.add(buttonsPanel);

		findWindow.add(mainFindPanel);
		findWindow.setVisible(true);

		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Find");
			}
		});
		

	}

}
