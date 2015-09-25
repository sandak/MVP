package GuiView;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import java.util.Timer;
import java.util.TimerTask;

public class Arrow extends Canvas {
	protected boolean state;
	Timer timer;
	TimerTask task;

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
		
//		Display.getDefault().syncExec(new Runnable() {
//		    public void run() {
//		    	redraw();
//		    }});
	}
	
	public void setBlink()
	{
		timer=new Timer();
	     
		task=new TimerTask() {
			int index = 0;
			@Override
			public void run() {
				getDisplay().syncExec(new Runnable() {
					@Override
					public void run() {
						if (index==0){
							setState(true);
							redraw();
							index =1;
						}else
						{
							setState(false);
							redraw();
							index =0;
						}
						
					}
				});}};}

	public Arrow(Composite parent,String green ,String red,int style) {
		super(parent, style);
		state = false;
		
		setBackground(new Color(null, 255, 255, 255));
		Canvas canvas = this;
		
		
		
    	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
			 
				Image image;
				if(state == true)
					   image = new Image(getDisplay(),green);
				else
					   image = new Image(getDisplay(),red);

			     int imageWidth = image.getBounds().width;
			     int imageHeight = image.getBounds().height;
			     int width = canvas.getSize().x;
			     int height = canvas.getSize().y;

			     e.gc.drawImage(image,0,0,imageWidth,imageHeight,0,0,width,height);
					canvas.getParent().redraw();
				
				  
			}
				      
				
		});
    	
	}

}
