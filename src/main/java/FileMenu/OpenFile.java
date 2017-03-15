package FileMenu;

public class OpenFile extends FileMenuCommand{

	FileMenuExecution fileMenuExecution;
	
	public OpenFile(FileMenuExecution fileMenu) {
		this.fileMenuExecution = fileMenu;
	}

	@Override
	public void execute() {
		fileMenuExecution.openFile();
	}

}
