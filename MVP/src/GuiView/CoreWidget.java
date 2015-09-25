package GuiView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class CoreWidget extends Canvas {

	protected int [][] maze;
	protected SelectionListener exitListener;
	protected SelectionListener generateListener;
	
	public int[][] getMaze() {
		return maze;
	}

	public void setMaze(int[][] maze) {
		this.maze = maze;
	}

	public SelectionListener getExitListener() {
		return exitListener;
	}

	public void setExitListener(SelectionListener exitListener) {
		this.exitListener = exitListener;
	}

	public SelectionListener getGenerateListener() {
		return generateListener;
	}

	public void setGenerateListener(SelectionListener generateListener) {
		this.generateListener = generateListener;
	}

	public CoreWidget(Composite parent, int style) {
		super(parent, style);
		Button generateButton=new Button(this, SWT.PUSH);
		generateButton.setText("  Generate new maze  ");
		generateButton.setLayoutData(new GridData(SWT.NONE, SWT.None, false, false, 1, 1));
		generateButton.addSelectionListener(generateListener);		
		
		//MazeDisplayer maze=new Maze2D(this, SWT.BORDER);		
		Maze3D mazeWidget=new Maze3D(this, SWT.BORDER);
		if (maze != null)
			mazeWidget.setMazeData(maze);
		mazeWidget.setFocus();
		mazeWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,5));
		mazeWidget.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.keyCode == SWT.ARROW_UP)
				{
					mazeWidget.moveUp();
				}
				if(arg0.keyCode == SWT.ARROW_DOWN)
				{
					mazeWidget.moveDown();
				}
				if(arg0.keyCode == SWT.ARROW_LEFT)
				{
					mazeWidget.moveLeft();
				}
				if(arg0.keyCode == SWT.ARROW_RIGHT)
				{
					mazeWidget.moveRight();
				}
			}
		});
		
		Button stopButton=new Button(this, SWT.PUSH);
		stopButton.setText("  Stop  ");
		stopButton.setLayoutData(new GridData(SWT.None, SWT.None, false, false, 1, 1));
		stopButton.setEnabled(false);
		
		// cube widget
		MazeCube mazeCube = new MazeCube(this, SWT.BORDER);
		mazeCube.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 2));
		
		// possibleMoves widget
		Canvas possibleMoves=new PossibleMoves(this,SWT.BORDER);
		possibleMoves.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, false, 1, 1));
		
	}
	

	
	
	
	
	

}
