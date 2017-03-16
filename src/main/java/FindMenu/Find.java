package FindMenu;

public class Find extends FindMenuCommand{

	FindMenuExecution findMenuExecution;
	
	public Find(FindMenuExecution findMenuExecution){
		this.findMenuExecution = findMenuExecution;
	}
	
	@Override
	public void execute() {
		findMenuExecution.find();
	}

}
