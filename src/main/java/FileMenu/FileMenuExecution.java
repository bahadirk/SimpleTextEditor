package FileMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import gui.TextArea;

public class FileMenuExecution {

	TextArea textArea;
	File currentDirectory = new File(System.getProperty("user.dir"));
	String currentFilePath;
	
	public FileMenuExecution(TextArea textArea){
		this.textArea = textArea;
	}

	public void openFile(){

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(currentDirectory);
		fileChooser.setDialogTitle("Open File");

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			currentFilePath = fileChooser.getSelectedFile().getPath();
			String context = "";
			textArea.setText("");

			try {
				Scanner reader = new Scanner(new FileReader(currentFilePath));
				while(reader.hasNextLine()){
					String currentLine = reader.nextLine();

					if(!currentLine.isEmpty()){
						context += currentLine;
					}
					context += "\n";
				}
				textArea.setText(context);
				reader.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}
	}

	public void saveFile(){
		if(currentFilePath == null){
			saveAsFile();
		}else{
			try {
				FileWriter fileWriter = new FileWriter(currentFilePath, false);
				fileWriter.write(textArea.getText());
				fileWriter.close();
				JOptionPane.showMessageDialog(null, "File saved");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveAsFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(currentDirectory);
		fileChooser.setDialogTitle("Save File");

		fileChooser.setDialogTitle("Choose a directory to save your file: ");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int returnValue = fileChooser.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if(fileChooser.getSelectedFile().exists()){
				int option = JOptionPane.showConfirmDialog(fileChooser, 
						"Do you want to overwrite file?", 
						"Confirm overwrite", 
						JOptionPane.YES_NO_OPTION);

				if (option == JOptionPane.YES_OPTION){
					fileChooser.approveSelection();
				}
			}
			try {
				currentFilePath = fileChooser.getSelectedFile().getPath();
				FileWriter fileWriter = new FileWriter(currentFilePath);
				fileWriter.write(textArea.getText());
				fileWriter.close();
				JOptionPane.showMessageDialog(null, "File saved");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void exitFile(){
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?");

		if(result == JOptionPane.OK_OPTION){
			String n = textArea.getText();
			System.out.println(n);
			if(textArea.getText() != ""){
				this.saveFile();	
			}

			System.exit(0);
		}
	}
}
