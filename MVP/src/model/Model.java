package model;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;

/**
 * Defines what every Model can do.
 * @author Guy Golan & Amit Sandak
 *
 */
public interface Model {

	/**
	 * Generate a Maze3d according to given sizes.
	 * @param name - tags the Maze3d in the hashMap by its name.
	 * @param x - the X dimension. 
	 * @param y - the Y dimension.
	 * @param z - the Z dimension.
	 */
	void generate(String name, int x, int y, int z);
	/**
	 * Displays a  Maze3d according to its name.
	 * @param name - the Maze3d name.
	 */
	Maze3d getMaze(String name);
	/**
	 * Calculates and displays(using controller) the crossSection by X.
	 * @param index - index of X.
	 * @param name - Maze3d name.
	 */
	void getCrossSectionByX(int index, String name);
	
	void getCrossSectionByY(int index, String name);
	/**
	 * Calculates and displays(using controller) the crossSection by Z.
	 * @param index - index of Z.
	 * @param name - Maze3d name.
	 */
	void getCrossSectionByZ(int index, String name);
	/**
	 * Save a Maze3d to the given file.
	 * @param name - Maze3d name.
	 * @param fileName - file name.
	 */
	void save(String name, String fileName);

	/**
	 * Load a compressed Maze3d from the given file name.
	 * @param fileName - the name of the file.
	 * @param name - the new uncompressed  and loaded Maze3d's name.
	 */
	void load(String fileName, String name);
	/**
	 * Checks the memory size of a Maze3d.
	 * @param name - Maze3d's name.
	 */
	void size(String name);
	/**
	 * Checks the compressed size of a Maze3d in a file.
	 * @param name - the Maze3d's name.
	 */
	void fileSize(String name);
	/**
	 * Solve a Maze3d.
	 * @param name - Maze3d's name.
	 * @param algorithm - the Search algorithm.
	 */
	void solve(String name, String algorithm);
	/**
	 * Display the solution (using the controller) of a Maze3d (by its name).
	 * @param name - Maze3d's name
	 */
	Solution<Position> getSolution(String name);
	/**
	 * Safely closing all resources.
	 */
	void exit();
	
	Position getCharPosition(String string);
}
