package FileMenu;

public class SaveFile extends FileMenuCommand {

	FileMenuExecution fileMenuExecution;
	
	public SaveFile(FileMenuExecution fileMenu) {
		this.fileMenuExecution = fileMenu;
	}

	@Override
	public void execute() {
		fileMenuExecution.saveFile();
	}

}
