package model;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeDomain;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
	 * Defines what MyModel does.
	 * @author Guy Golan & Amit Sandak.
	 *
	 */
public class MyObservableModel extends ObservableCommonModel {


		public MyObservableModel() {			//Ctor
			super();
		}
		
		@Override
		public void generate(String name, int x, int y, int z) {
			
			threadPool.execute( new Runnable() {			//generating process occurs in a thread.
				
				@Override
				public void run() {
					Maze3d maze = new MyMaze3dGenerator().generate(x, y, z);
					mazeMap.put(name, maze);
					controller.display("The "+name+" maze is ready.");
					
				}
			});
			
		}


		@Override
		public void mazeDisplay(String name) {
			Maze3d  temp = mazeMap.get(name);
			
			if(temp != null)
			{
				controller.display(name+ "\n" +temp.toString());	
			}
			else
			{
				controller.display("Unavailable maze!");
			}
		}

		@Override
		public void displayCrossSectionByX(int index, String name) {
			Maze3d  tmpMaze = mazeMap.get(name);
			
			if(tmpMaze != null)
			{
				controller.display(arrIntToString(tmpMaze.getCrossSectionByX(index)));	
			}
			else
			{
				controller.display("Unavailable maze!");
			}		
		}


		@Override
		public void displayCrossSectionByY(int index, String name) {
			Maze3d  tmpMaze = mazeMap.get(name);
			
			if(tmpMaze != null)
			{
				controller.display(arrIntToString(tmpMaze.getCrossSectionByY(index)));	
			}
			else
			{
				controller.display("Unavailable maze!");
			}		
			
		}

		@Override
		public void displayCrossSectionByZ(int index, String name) {
			Maze3d  tmpMaze = mazeMap.get(name);
			
			if(tmpMaze != null)
			{
				controller.display(arrIntToString(tmpMaze.getCrossSectionByZ(index)));	
			}
			else
			{
				controller.display("Unavailable maze!");
			}		
			
		}
		
		/**
		 * Converts a dou - dimensional array into a String.
		 * @param arr - a plain.
		 * @return a string containing the plain.
		 */
		private String arrIntToString(int[][] arr) {
			String s = "";
			
			for (int[] i : arr)
			{
				for(int j : i)
				{
					s = s + j + " ";
					
				}
				s = s+ "\n";
			}
			
			return s;
		}

		@Override
		public void save(String name, String fileName) {
			Maze3d  tmpMaze = mazeMap.get(name);
			
			if(tmpMaze != null)
			{
				try {
					MyCompressorOutputStream tmpCompressor = new MyCompressorOutputStream(new FileOutputStream(fileName));
					tmpCompressor.write(tmpMaze.toByteArray());
					tmpCompressor.close();									//compressing the maze into and writing it to the file.
					controller.display(name + " maze saved to " + fileName + ".");
				} catch (FileNotFoundException e) {
					controller.display("wrong file path");
				} catch (IOException e)
				{
					controller.display("general error");
				}
			}
			else
			{
				controller.display("Unavailable maze!");
			}				
		}

		@Override
		public void load(String fileName, String name) {
			try {
					MyDecompressorInputStream tmpDecompressor = new MyDecompressorInputStream(new FileInputStream(fileName));
					byte [] buffer = new byte[35*35*35]; 	//15 is the maximum supported maze in the compressor
					if (tmpDecompressor.read(buffer)==-1)
					{
						Maze3d  tmpMaze = new Maze3d(buffer);
						mazeMap.put(name, tmpMaze);
						controller.display(name + " maze loaded.");
						tmpDecompressor.close();
					}
					else
					{
						controller.display("the requsted maze is too big!");
					}
				} 
				catch (FileNotFoundException e) 
				{
					controller.display("wrong file path");
				} 
				catch (IOException e)
				{
					controller.display("general error");
				}
				
		}

		@Override
		public void size(String name) {
			
			
			Maze3d tempMaze = mazeMap.get(name);
			if(tempMaze!=null)
			{
				controller.display("the size of " + name  + " maze in the memory is: "+(tempMaze.getxAxis()* tempMaze.getyAxis()*tempMaze.getzAxis()+9)+".");
			}
			else
			{
				controller.display(name+" is Unavailable!");
			}
			
		}

		@Override
		public void fileSize(String name) {
			Maze3d  tmpMaze = mazeMap.get(name);
			
			if(tmpMaze != null)
			{
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				MyCompressorOutputStream compress = new MyCompressorOutputStream(buffer);
				try 
				{
					compress.write(tmpMaze.toByteArray());    //trying to compress the maze into the buffer.
					controller.display("the size of " + name + " maze in file is: " + buffer.size());
				} 
				catch (IOException e) {
					controller.display("general error");
				}
				finally {
					try 
					{
						compress.close();		//closing resources.
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else
			{
				controller.display("Unavailable maze!");
			}	
			
		}

		@Override
		public void solve(String name, String algorithm) {
			threadPool.execute(new Runnable() {			//solving the maze in a new thread
				
				@Override
				public void run() {
					
					Maze3d tmpMaze = mazeMap.get(name);
					if(tmpMaze!=null)
					{
						Searcher<Position> alg;
						switch(algorithm)							//generating a Searcher according to the parameters.
						{
						case "BFS":
							alg = new BFS<Position>();
							break;
						case "AstarManhattan":
							alg = new AStar<Position>(new MazeManhattanDistance(new State<Position>(tmpMaze.getExit())));
							break;
						case "AstarAirDistance":
							alg = new AStar<Position>(new MazeAirDistance(new State<Position>(tmpMaze.getExit())));
							break;
							
						default :
							controller.display(algorithm+" is not a valid algorithm! \nValid algorithms are : <BFS>, <AstarManhattan>, <AstarAirDistance>.");
							return;
						}
						solutionMap.put(name,alg.search(new MazeDomain(tmpMaze)));		//inserting the Solution into the solution map.
						controller.display("solution for " +name+ " is ready");
					}
					else
					{
						controller.display(name+ " maze is unavailable!");
					}
					
								
				}
			});
		}

		@Override
		public void displaySolution(String name) {
			Solution<Position>  tmp = solutionMap.get(name);
			
			if(tmp != null)
			{
				controller.display("the solution of " +name+ " maze is:\n" +(tmp.toString()));	
			}
			else
			{
				controller.display("Unavailable solution!");
			}
		

			
		}

		@Override
		public void exit() {			//safely terminating the existing threads.
			try {
				threadPool.shutdown();
				if (!threadPool.awaitTermination(5,TimeUnit.SECONDS ))
				{
					threadPool.shutdownNow();
					controller.display("threads terminated violently!");
				}
				else
					controller.display("all threads terminated!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
				
		}
	}

	
	
	
	
	

