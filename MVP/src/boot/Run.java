package boot;


import cliView.MyObservableCLIView;
import model.MyObservableModel;
import presenter.Presenter;

public class Run {

	public static void main(String[] args) {
		
		MyObservableModel model = new MyObservableModel();
		MyObservableCLIView view = new MyObservableCLIView();
		Presenter presenter = new Presenter(model,view);
		
		view.addObserver(presenter);
		model.addObserver(presenter);
		
		

	}

}
