package GuiView;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class MyObservableGuiView extends ObservableCommonGuiView {

	MazeWindow mainWindow;
	public MyObservableGuiView(String title, int width, int hight) {
		mainWindow = new MazeWindow(title, width, hight);
		mainWindow.setExitListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				exitRequest();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		mainWindow.setGenerateListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("generate 3d maze gui 15 15 15");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void display(String[] strings) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		mainWindow.exit();

	}

	@Override
	public void start() {
		mainWindow.run();
	}

	@Override
	public void exitRequest() {
		setChanged();
		notifyObservers("exit");
		
	}

	@Override
	public void display(int[][] maze) {
		mainWindow.setMazeData(maze);
		
	}

}
