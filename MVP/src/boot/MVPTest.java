package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.MyObservableModel;
import presenter.Presenter;
import view.MyObservableCLIView;

public class MVPTest {

	public static void main(String[] args) {
		MyObservableCLIView view = new MyObservableCLIView(new BufferedReader(new InputStreamReader(System.in)) , new PrintWriter(System.out));
		MyObservableModel model = new MyObservableModel();
		Presenter p = new Presenter(model,view);
		
		model.addObserver(p);
		view.addObserver(p);
		
		view.start();
	}

}
