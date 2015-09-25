package GuiView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import java.util.Timer;
import java.util.TimerTask;

public class Maze2D extends MazeDisplayer{
char crossection;
Timer timer;
TimerTask task;
Image image;
int[] position2d;

	 public Maze2D(Composite parent,int style){
	        super(parent, style);
	        Canvas canvas = this;
	        crossection = 'x'; //default
	    	// set a white background   (red, green, blue)
	    	setBackground(new Color(null, 255, 255, 255));
	    	addPaintListener(new PaintListener() {
	    		
				
				@Override
				public void paintControl(PaintEvent e) {
					   e.gc.setForeground(new Color(null,0,0,0));
					   e.gc.setBackground(new Color(null,0,0,0));

					   int width=getSize().x;
					   int height=getSize().y;
					   if ((mazeData!=null)&&(charPosition!=null))
					   {
					   int[][] maze2d = null;
					   position2d = null;
			    		switch (crossection)
			    		{
			    		case 'x':
			    			maze2d = mazeData.getCrossSectionByX(charPosition.getX());
			    			position2d = new int [] {charPosition.getZ(),charPosition.getY()};
			    			break;
			    		case 'y':
			    			maze2d = mazeData.getCrossSectionByY(charPosition.getY());
			    			position2d = new int [] {charPosition.getZ(),charPosition.getX()};
			    			break;
			    		case 'z':
			    			maze2d = mazeData.getCrossSectionByZ(charPosition.getZ());
			    			position2d = new int [] {charPosition.getY(),charPosition.getX()};
			    			break;
			    			default:
			    				//TODO
			    		}
			    		
					   int w=width/maze2d[0].length;
					   int h=height/maze2d.length;

					   for(int i=0;i<maze2d.length;i++)
					      for(int j=0;j<maze2d[i].length;j++){
					          int x=j*w;
					          int y=i*h;
					          if(maze2d[i][j]!=0)
					              e.gc.fillRectangle(x,y,w,h);
					      }
						 image = new Image(getDisplay(),"resources/pacman.png");
					     int imageWidth = image.getBounds().width;
					     int imageHeight = image.getBounds().height;
					     int resizeWidth = w;
					     int resizeHeight = h;   
					    // e.gc.drawImage(image,0,0,imageWidth,imageHeight,position2d[0]*w,position2d[1]*h,resizeWidth,resizeHeight);
						Arrow pacman = new Arrow(canvas, "resources/pacman.png", "resources/closedpacman.png", SWT.NO_BACKGROUND);
						pacman.setLocation(position2d[0]*w,position2d[1]*h);
						pacman.redraw(position2d[0]*w, position2d[1]*h, resizeWidth, resizeHeight, true);
						pacman.setBlink();
					     
						timer=new Timer();
					     
							task=new TimerTask() {
								int index = 0;
								@Override
								public void run() {
									getDisplay().syncExec(new Runnable() {
										@Override
										public void run() {
											if (index==0){
												pacman.setState(true);
												index =1;
											}else
											{
												pacman.setState(false);
												index =0;
											}
											//e.gc.notify();
											// e.gc.drawImage(image,0,0,imageWidth,imageHeight,position2d[0]*w,position2d[1]*h,resizeWidth,resizeHeight);
										}
									});
								}
							};				
							timer.scheduleAtFixedRate(task, 0, 100);				
							
						
						  
					}}
			});
	 }

}
