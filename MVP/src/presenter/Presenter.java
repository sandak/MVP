package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class Presenter implements Observer {
	private MvpModel model;
	private View view;
	
	
	public Presenter(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void update(Observable comp, Object id) {
		String identifier = ((String)id).split(" : ")[0];
		String[] param = ((String)id).split(" : ");
		
			
			if (comp == model)
			{
				switch (identifier) 
				{
				case ("maze is ready"):
					view.display("The "+param+" maze is ready.");
					break;
					default:
						break;
				}
			}
			else if (comp == view)
			{
				switch (identifier)
				{
				case ("maze request"):
					model.getMaze(param[0]);
				default:
					break;
					
				}

			}
	}
	
}

