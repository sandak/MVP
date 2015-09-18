package model;

import java.util.Observable;

import controller.Controller;

public class ObservableMvpMyModelAdaptor extends Observable implements Controller {

	protected Model model;
	
	
	public ObservableMvpMyModelAdaptor(Model model) {
		super();
		this.model = model;
	}

	@Override
	public void display(String string) {
		notifyObservers("display : " + string);

	}

	@Override
	public void display(String[] strings) {
		// TODO Auto-generated method stub ?/?

	}

	@Override
	public void mazeDisplay(String name) {
		model.mazeDisplay(name);

	}

	public void getMaze(String name) {
		mazeDisplay(name);
		
	}

	@Override
	public void generate(String name, int x, int y, int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayCrossSectionByX(int index, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayCrossSectionByY(int index, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayCrossSectionByZ(int index, String name) {
		// TODO Auto-generated method stub

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
