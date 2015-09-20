package GuiView;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Arrow extends Canvas {

	public Arrow(Composite parent,String green ,String red,int style) {
		super(parent, style);
		
		setBackground(new Color(null, 255, 255, 255));
		Canvas canvas = this;
		
		
		
    	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
			 
				Image image;
				if(canvas.getParent().getParent().getSize().x>400)
					   image = new Image(getDisplay(),green);
				else
					   image = new Image(getDisplay(),red);

			     int imageWidth = image.getBounds().width;
			     int imageHeight = image.getBounds().height;
			     int width = canvas.getSize().x;
			     int height = canvas.getSize().y;

			 //Image scaled050 = new Image(getDisplay(),image.getImageData().scaledTo(width,height));
			// Image scaledGC200 = new Image(getDisplay(),width,height);    
			     e.gc.drawImage(image,0,0,imageWidth,imageHeight,0,0,width,height);
					canvas.getParent().redraw();
				
				  
			}
				      
				
		});
    	
	}

}
