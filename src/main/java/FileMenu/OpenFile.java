package FileMenu;

public class OpenFile extends FileMenuCommand{

	FileMenuExecution fileMenu;
	
	public OpenFile(FileMenuExecution fileMenu) {
		this.fileMenu = fileMenu;
	}

	@Override
	public void execute() {
		fileMenu.openFile();
	}

}
