package GuiView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithms.mazeGenerators.Maze3d;

public class Run {

	public static void main(String[] args) {
	Form<Maze3d> f =	new Form<Maze3d> (new Maze3d(10, 10, 10),"form",250,250);
	f.run();

		System.out.println(f.getObject());

	}

}
