package presenter;

/**
 * Defines what the Command Display should do.
 * @author Guy Golan & Amit Sandak
 *
 */
public class Display extends CommonCommand {

	public Display(Controller controller) {		//Ctor
		super(controller);
	}
	
	/**
	 * According to the parameters, displays the Maze3d ,solution or the crossSection.
	 * @param param - parameters for the Command. 
	 */
	@Override
	public void doCommand(String param) {
		String[] s = param.split(" ");
		if ((s[0].equals("cross"))&&(s.length > 5))		//validates if there are no missing parameters
		{
			try{
			switch (s[3])
			{
			case "x":
			case "X":
				controller.displayCrossSectionByX(Integer.parseInt(s[4]),s[6]);
				break;
			case "y":
			case "Y":
				controller.displayCrossSectionByY(Integer.parseInt(s[4]),s[6]);
				break;
			case "z":		
			case "Z":
				controller.displayCrossSectionByZ(Integer.parseInt(s[4]),s[6]);
				break;
			default:
				controller.display("Invalid parameter");
			}
			}catch (NumberFormatException e) {
				
				controller.display("Invalid parameters.");

			}
				 
		}
		else if ((s[0].equals("solution"))&&(s.length > 1))		//checks if the first parameter is "solution"
		{
			controller.displaySolution(s[1]);
		}
		else
		controller.mazeDisplay(param);
	}

}
