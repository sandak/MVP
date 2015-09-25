package GuiView;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class Exit implements Listener {

	MyObservableGuiView view;
	
	public Exit(MyObservableGuiView view) {
		this.view = view;
	}
	
	@Override
	public void handleEvent(Event arg0) {
		view.exitRequest();

	}

}
