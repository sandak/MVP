package GuiView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
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

public class MazeWindow extends BasicWindow{

	Timer timer;
	TimerTask task;
	
	public MazeWindow(String title, int width, int height) {
		super(title, width, height);
	}

	private void randomWalk(MazeDisplayer maze){
		Random r=new Random();
		boolean b1,b2;
		b1=r.nextBoolean();
		b2=r.nextBoolean();
		if(b1&&b2)
			maze.moveUp();
		if(b1&&!b2)
			maze.moveDown();
		if(!b1&&b2)
			maze.moveRight();
		if(!b1&&!b2)
			maze.moveLeft();
		
		maze.redraw();
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
		    fileExitItem.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					shell.dispose();
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {}
			});

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
        
		Button startButton=new Button(shell, SWT.PUSH);
		startButton.setText("Start");
		startButton.setLayoutData(new GridData(SWT.NONE, SWT.None, false, false, 1, 1));
				
		
		//MazeDisplayer maze=new Maze2D(shell, SWT.BORDER);		
		MazeDisplayer maze=new Maze3D(shell, SWT.BORDER);
		maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,3));
		
		Button stopButton=new Button(shell, SWT.PUSH);
		stopButton.setText("Stop");
		stopButton.setLayoutData(new GridData(SWT.None, SWT.None, false, false, 1, 1));
		stopButton.setEnabled(false);
		
		Canvas possibleMoves=new PossibleMoves(shell,SWT.BORDER);
		possibleMoves.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		startButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				timer=new Timer();
				task=new TimerTask() {
					@Override
					public void run() {
						display.syncExec(new Runnable() {
							@Override
							public void run() {
								randomWalk(maze);
							}
						});
					}
				};				
				timer.scheduleAtFixedRate(task, 0, 100);				
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		stopButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				task.cancel();
				timer.cancel();
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
	}
	
	public static void main(String[] args) {
		MazeWindow win=new MazeWindow("maze example", 800, 700);
		win.run();
	}

}
