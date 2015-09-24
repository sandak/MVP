package presenter;

/**
 * Defines what the Command FileSize should do.
 * @author Guy Golan & Amit Sandak
 *
 */
public class FileSize extends CommonCommand {

	public FileSize(Controller controller) {	//Ctor
		super(controller);
	}

	/**
	 * Using the Controller to check what the given Maze3d(name) size in a file. 
	 * @param name - the Maze3d's name.
	 */
	@Override
	public void doCommand(String name) {

		String s[] = name.split(" ");
		
		if(s.length > 1)
		{
			controller.fileSize(s[1]);
		}
		else
		{
			controller.display("Missing parameters.");
		}

	}

	

}
