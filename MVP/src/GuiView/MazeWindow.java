package GuiView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class MazeWindow extends BasicWindow{
	protected Maze3d maze;
	protected Position charPosition;
	protected SelectionListener exitListener;
	protected SelectionListener generateListener;
	ArrayList<MazeDisplayer> widgetsList;
	
	public void setMazeData(Maze3d maze)
	{
		this.maze = maze;
		widgetsRefresh();
	
	}
	public void setGenerateListener(SelectionListener generateListener) {
		this.generateListener = generateListener;
	}


	public MazeWindow( String title, int width, int height) {
		super(title, width, height);
		widgetsList = new ArrayList<MazeDisplayer>();
	}


	public void setExitListener(SelectionListener exitListener) {
		this.exitListener = exitListener;
	}

	

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2,false));		
		
	
		    Menu menuBar = new Menu(shell, SWT.BAR);
		    MenuItem fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		    fileMenuHeader.setText("&File");

		    Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		    fileMenuHeader.setMenu(fileMenu);

		    MenuItem fileOpenPropItem = new MenuItem(fileMenu, SWT.PUSH);
		    fileOpenPropItem.setText("Open properties file");
		    fileOpenPropItem.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					FileDialog fd=new FileDialog(shell,SWT.OPEN);
					fd.setText("open");
					String[] filterExt = { ".xml" };
					fd.setFilterExtensions(filterExt);
					String selected = fd.open();
						// TODO connect to mvp
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {}
			});

		    MenuItem fileEditPropItem = new MenuItem(fileMenu, SWT.PUSH);
		    fileEditPropItem.setText("Edit properties");
		    
		    MenuItem fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		    fileExitItem.setText("Exit");
		    fileExitItem.addSelectionListener(exitListener);

		    MenuItem MazeMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		    MazeMenuHeader.setText("Maze");

		    Menu MazeMenu = new Menu(shell, SWT.DROP_DOWN);
		    MazeMenuHeader.setMenu(MazeMenu);

		    MenuItem mazePropItem = new MenuItem(MazeMenu, SWT.PUSH);
		    mazePropItem.setText("Maze properties");
		    mazePropItem.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					Shell mazeProp = new Shell(shell);
					mazeProp.setText("Maze Properties");
					mazeProp.setSize(130,120);
					mazeProp.setLayout(new GridLayout(6, false));
					Label xTitle = new Label(mazeProp, SWT.COLOR_WIDGET_DARK_SHADOW);
					xTitle.setText("Dimensions: ");
					xTitle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 6, 1));	
					Label xxTitle = new Label(mazeProp, SWT.COLOR_WIDGET_DARK_SHADOW);
					xxTitle.setText("X");
					Text xTextBox =	new Text(mazeProp, SWT.BORDER);
				    xTextBox.setText("  ");
					Label yyTitle = new Label(mazeProp, SWT.COLOR_WIDGET_DARK_SHADOW);
					yyTitle.setText("Y");
				    Text yTextBox =	new Text(mazeProp, SWT.BORDER);
				    yTextBox.setText("  ");
					Label ZZTitle = new Label(mazeProp, SWT.COLOR_WIDGET_DARK_SHADOW);
					ZZTitle.setText("Z");
				    Text zTextBox =	new Text(mazeProp, SWT.BORDER);
				    zTextBox.setText("  ");
				    Button saveButton =  new Button(mazeProp, SWT.PUSH);
				    saveButton.setText(" Save ");
				    saveButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 6, 1));	
					
					mazeProp.open();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {}
			});
		    
		    
		    shell.setMenuBar(menuBar);
        
		Button generateButton=new Button(shell, SWT.PUSH);
		generateButton.setText("  Generate new maze  ");
		generateButton.setLayoutData(new GridData(SWT.NONE, SWT.None, false, false, 1, 1));
		generateButton.addSelectionListener(generateListener);		
		
		MazeDisplayer mazeWidget=new Maze2D(shell, SWT.BORDER);	
		widgetsList.add(mazeWidget);
		//Maze3D mazeWidget=new Maze3D(shell, SWT.BORDER);
		mazeWidget.setFocus();
		mazeWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,5));
		mazeWidget.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
//				if(arg0.keyCode == SWT.ARROW_UP)
//				{
//					mazeWidget.moveUp();
//				}
//				if(arg0.keyCode == SWT.ARROW_DOWN)
//				{
//					mazeWidget.moveDown();
//				}
//				if(arg0.keyCode == SWT.ARROW_LEFT)
//				{
//					mazeWidget.moveLeft();
//				}
//				if(arg0.keyCode == SWT.ARROW_RIGHT)
//				{
//					mazeWidget.moveRight();
//				}
			}
		});
		
		Button stopButton=new Button(shell, SWT.PUSH);
		stopButton.setText("  Stop  ");
		stopButton.setLayoutData(new GridData(SWT.None, SWT.None, false, false, 1, 1));
		stopButton.setEnabled(false);
		
		// cube widget
		MazeCube mazeCube = new MazeCube(shell, SWT.BORDER);
		mazeCube.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 2));
		widgetsList.add(mazeCube);
		
		// possibleMoves widget
		MazeDisplayer possibleMoves=new PossibleMoves(shell,SWT.BORDER);
		possibleMoves.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, false, 1, 1));
		widgetsList.add(possibleMoves);
		
	}
	
	protected void exitRequest() {
		shell.dispose();

	}
	
	public void widgetsRefresh()
	{
		for (MazeDisplayer canvas : widgetsList) {
			if(maze!=null)
				canvas.setMazeData(maze);
			if(charPosition!=null)
				canvas.setCharPosition(charPosition);
			
		}
	}
	public void setPositionData(Position charPosition) {
		this.charPosition = charPosition;
		widgetsRefresh();
		
	}
}


	
