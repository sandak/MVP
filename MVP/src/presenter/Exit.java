package presenter;

/**
 * Defines what the Command Exit should do.
 * @author Guy Golan & Amit Sandak
 *
 */
public class Exit extends CommonCommand {

	public Exit(Presenter presenter) {	//Ctor
		super(presenter);
	}

	/**
	 * Activates a chain of safe exit using the Controller.
	 */
	@Override
	public void doCommand(String param) {
		System.out.println("PRESENTER EXIT");
		presenter.getView().exit();
		presenter.getModel().exit();
		
		
	}

}
