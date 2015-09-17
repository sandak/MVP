package boot;

import model.Model;
import model.MyModel;
import presenter.Presenter;
import view.MyObservableCLIView;
import view.View;

public class Run {

	public static void main(String[] args) {
		
		MyModel model = new MyModel();
		MyObservableCLIView view = new MyObservableCLIView();
		Presenter presenter = new Presenter(model,view);
		
		view.addObserver(presenter);
		model.addObserver(presenter);
		
		

	}

}
