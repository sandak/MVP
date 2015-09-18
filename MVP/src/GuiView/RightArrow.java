package GuiView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class RightArrow extends Canvas {

	public RightArrow(Composite parent, int style) {
		super(parent, style);
		setBackground(new Color(null, 255, 255, 255));
		Canvas arrow1 = this;
    	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
			 
			if(arrow1.getParent().getParent().getSize().x>400)
			{
			    Image image = new Image(getDisplay(),"resources/rightGreen.png");
				  // 	e.gc.drawImage(image, 0, 0);
				    Image scaledGC = new Image(getDisplay(),(int)(arrow1.getSize().x*0.1),(int)(arrow1.getSize().y*0.1));
				    //GC gc = new GC(scaledGC);
				    e.gc.drawImage(image,0,0,arrow1.getSize().x,arrow1.getSize().y,0,0,(int)(arrow1.getSize().x*0.1),(int)(arrow1.getSize().x*0.1));
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
				  
				   Image scaledGC = new Image(getDisplay(),(int)(arrow1.getSize().x*0.3),(int)(arrow1.getSize().y*0.3));
				  e.gc.drawImage(image,0,0,arrow1.getSize().x,arrow1.getSize().y,0,0,(int)(arrow1.getSize().x*0.3),(int)(arrow1.getSize().x*0.3));
		
			}

				
				  
					}
				      
				
		});
    	
 }

}
