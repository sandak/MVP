package boot;

import GuiView.MyObservableGuiView;
import model.MyObservableModel;
import presenter.Presenter;

public class MVPTest {

	public static void main(String[] args) {
		//MyObservableCLIView view = new MyObservableCLIView(new BufferedReader(new InputStreamReader(System.in)) , new PrintWriter(System.out));
		MyObservableGuiView view = new MyObservableGuiView("MAZE GAME", 500, 700);
		
		MyObservableModel model = new MyObservableModel();
		Presenter p = new Presenter(model,view);
		
		model.addObserver(p);
		view.addObserver(p);
		
		view.start();
	}

}
