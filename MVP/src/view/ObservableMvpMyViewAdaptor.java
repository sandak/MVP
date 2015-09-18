package view;

import java.util.Observable;

import controller.Controller;

public class ObservableMvpMyViewAdaptor extends Observable implements Controller {
	protected View view;
	
	
	public ObservableMvpMyViewAdaptor(View view) {
		super();
		this.view = view;
	}

	@Override
	public void display(String string) {
		view.display(string);
	}

	@Override
	public void display(String[] strings) {
		view.display(strings);

	}

	@Override
	public void mazeDisplay(String name) {
		notifyObservers("maze request : " + name);

	}

	@Override
	public void generate(String name, int x, int y, int z) {
		notifyObservers("generate request : " + name + " : "+x+ " : "+y+ " : "+z+ " : ");
	}

	@Override
	public void displayCrossSectionByX(int index, String name) {
		notifyObservers("crossX request : " + name + " : "+index);

	}

	@Override
	public void displayCrossSectionByY(int index, String name) {
		notifyObservers("crossY request : " + name + " : "+index);
	}

	@Override
	public void displayCrossSectionByZ(int index, String name) {
		notifyObservers("crossZ request : " + name + " : "+index);

	}

	@Override
	public void save(String name, String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String fileName, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void size(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fileSize(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void solve(String name, String algorithm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displaySolution(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
