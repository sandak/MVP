package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class Presenter implements Observer {
	private Model model;
	private View view;
	
	
	public Presenter(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
			

	}

}
