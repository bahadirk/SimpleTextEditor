package FileMenu;

public class SaveAsFile extends FileMenuCommand{

	FileMenuExecution fileMenuExecution;
	
	public SaveAsFile(FileMenuExecution fileMenuExecution){
		this.fileMenuExecution = fileMenuExecution;
	}
	
	@Override
	public void execute() {
		fileMenuExecution.saveAsFile();
	}

}
