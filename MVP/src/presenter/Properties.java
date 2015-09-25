package presenter;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Properties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int mazeMaxAxisX;
	protected int mazeMaxAxisY;
	protected int mazeMaxAxisZ;
	protected String generateAlgorithm;
	protected String solveAlgorithm;
	
	protected int maxThreads;

	public int getMazeMaxAxisX() {
		return mazeMaxAxisX;
	}

	public void setMazeMaxAxisX(int mazeMaxAxisX) {
		this.mazeMaxAxisX = mazeMaxAxisX;
	}

	public int getMazeMaxAxisY() {
		return mazeMaxAxisY;
	}

	public void setMazeMaxAxisY(int mazeMaxAxisY) {
		this.mazeMaxAxisY = mazeMaxAxisY;
	}

	public int getMazeMaxAxisZ() {
		return mazeMaxAxisZ;
	}

	public void setMazeMaxAxisZ(int mazeMaxAxisZ) {
		this.mazeMaxAxisZ = mazeMaxAxisZ;
	}

	public String getGenerateAlgorithm() {
		return generateAlgorithm;
	}

	public void setGenerateAlgorithm(String generateAlgorithm) {
		this.generateAlgorithm = generateAlgorithm;
	}

	public String getSolveAlgorithm() {
		return solveAlgorithm;
	}

	public void setSolveAlgorithm(String solveAlgorithm) {
		this.solveAlgorithm = solveAlgorithm;
	}

	public int getMaxThreads() {
		return maxThreads;
	}

	public void setMaxThreads(int maxThreads) {
		this.maxThreads = maxThreads;
	}

	
}
