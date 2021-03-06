package presenter;

/**
 * Defines what the Command Save should do.
 * @author Guy Golan & Amit Sandak.
 *
 */
public class Save extends CommonCommand {

	public Save(Controller controller) {	//Ctor
		super(controller);
	}

	
	/**
	 * Using the Controller to save a Maze3d to a file.
	 * @param param - parameters.
	 */
	@Override
	public void doCommand(String param) {
		String s[] = param.split(" ");
		
		if(s.length > 2)
		{
			controller.save(s[1],s[2]);
		}
		else
		{
			controller.display("Missing parameters.");
		}
		
	}
}
