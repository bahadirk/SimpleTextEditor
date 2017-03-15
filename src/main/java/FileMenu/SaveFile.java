package FileMenu;

public class SaveFile extends FileMenuCommand {

	FileMenuExecution fileMenu;
	
	public SaveFile(FileMenuExecution fileMenu) {
		this.fileMenu = fileMenu;
	}

	@Override
	public void execute() {
		fileMenu.saveFile();
	}

}
