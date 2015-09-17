package boot;

import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import presenter.Properties;

public class PropertiesGenerate {

	public static void main(String[] args) throws FileNotFoundException {
	/*	Properties p = new Properties();
		p.setMaxThreads(10);
		p.setMazeMaxAxisX(15);
		p.setMazeMaxAxisY(15);
		p.setMazeMaxAxisZ(15);
		p.setSolveAlgorithm("BFS");
		p.setGenerateAlgorithm("MyMaze3dGenerator");
		FileOutputStream file;
		try {
			file = new FileOutputStream("properties.xml");
		
		java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(file);
		xe1.writeObject(p);
		xe1.flush();
		xe1.close();
} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

		
		FileInputStream file = new FileInputStream("properties.xml");
		
		java.beans.XMLDecoder xe1 = new java.beans.XMLDecoder(file);
		Properties p = (Properties)xe1.readObject();
		xe1.close();
		System.out.println(p.getMaxThreads()+ " " + p.getSolveAlgorithm());
	}

}
