package FileMenu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileMenuExecution {

	JEditorPane textArea;
	File currentDirectory = new File(System.getProperty("user.dir"));

	public FileMenuExecution(JEditorPane textArea){
		this.textArea = textArea;
		
	}

	public void openFile(){

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(currentDirectory);
		fileChooser.setDialogTitle("Open File");

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String context = "";

			try {
				Scanner reader = new Scanner(new FileReader(selectedFile));
				//BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
				while(reader.hasNextLine()){
					String currentLine = reader.nextLine();
					
					if(!currentLine.isEmpty()){
						System.out.println(currentLine);
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
					try {
						FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile().getPath());
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						bufferedWriter.write(textArea.getText());

						bufferedWriter.close();
						fileWriter.close();

						fileChooser.approveSelection();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
