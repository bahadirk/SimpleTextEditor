package FileMenu;

public class ExitFile extends FileMenuCommand {

	FileMenuExecution fileMenuExecution;
	
	public ExitFile(FileMenuExecution fileMenuExecution){
		this.fileMenuExecution = fileMenuExecution;
	}
	
	@Override
	public void execute() {
		fileMenuExecution.exitFile();
	}

}
