package view;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public interface View {

	public void display(String[] strings);
	public void display(String string);
	public void display(Maze3d maze);
	public void exit() ;
	public void start();
	void exitRequest();
	public void display(Position charPosition);
	

}
