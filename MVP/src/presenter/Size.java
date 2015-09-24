package presenter;

/**
 * Defines what the Command Size should do.
 * @author Guy Golan & Amit Sandak.
 *
 */
public class Size extends CommonCommand {

	public Size(Controller controller) {	//Ctor
		super(controller);
	}

	/**
	 * Using the Controller to save a Maze3d to a file.
	 * @param name - the name of the Maze3d.
	 */
	@Override
	public void doCommand(String name) {
		
		String s[] = name.split(" ");
		
		if(s.length > 1)
		{
			controller.size(s[1]);
		}
		else
		{
			controller.display("Missing parameters.");
		}

	}

}
