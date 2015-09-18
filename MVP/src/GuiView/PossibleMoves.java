package GuiView;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.SYSTEMTIME;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PossibleMoves extends Canvas {

	public PossibleMoves(Composite parent, int style) {
		super(parent, style);
		setBackground(new Color(null, 255, 255, 255));
		Canvas canvas = this;
    	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				
//				GC gc = new GC(canvas);
			if(canvas.getParent().getSize().x>400)
			{
			    Image image = new Image(getDisplay(),"resources/rightGreen.png");
				  // 	e.gc.drawImage(image, 0, 0);
				    Image scaledGC = new Image(getDisplay(),(int)(canvas.getSize().x*0.5),(int)(canvas.getSize().y*0.5));
				    //GC gc = new GC(scaledGC);
				    e.gc.drawImage(image,0,0,canvas.getSize().x,canvas.getSize().y,0,0,(int)(canvas.getSize().x*0.5),(int)(canvas.getSize().x*0.5));
			}
			else
			{
				  Image image = new Image(getDisplay(),"resources/rightRed.png");
	
					    final int width = image.getBounds().width;
					    final int height = image.getBounds().height;

					final Image scaled050 = new Image(getDisplay(),
					        image.getImageData().scaledTo((int)(width*0.5),(int)(height*0.5)));
					    final Image scaled200 = new Image(getDisplay(),
					        image.getImageData().scaledTo((int)(width*2),(int)(height*2)));

					final Image scaledGC200 = new Image(getDisplay(),(int)(width*2),(int)(height*2));
					    GC gc = new GC(scaledGC200);
					    gc.drawImage(image,0,0,width,height,0,0,width*2,height*2);
					    
					     e.gc.drawImage(image,0,0,width,height,0,0,(int)(width*0.5),(int)(height*0.5));
					        e.gc.drawImage(scaled050,100,0);
					        e.gc.drawImage(scaledGC200,0,75);
					        e.gc.drawImage(scaled200,225,175);
				  
				   Image scaledGC = new Image(getDisplay(),(int)(canvas.getSize().x*0.3),(int)(canvas.getSize().y*0.3));
				  e.gc.drawImage(image,0,0,canvas.getSize().x,canvas.getSize().y,0,0,(int)(canvas.getSize().x*0.3),(int)(canvas.getSize().x*0.3));
		
			}

				
				  
				   
				      }
				
		});
    	
 }

	}




