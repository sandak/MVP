package GuiView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class PossibleMoves extends Canvas {

	public PossibleMoves(Composite parent, int style) {
		super(parent, style);
		setBackground(new Color(null, 255, 255, 255));
		Canvas canvas = this;
		canvas.setLayout(new GridLayout(4,false));
		new Arrow(canvas,"resources/upGreen.png","resources/rightRed.png", SWT.FILL);
		new RightArrow(canvas, SWT.FILL);
    	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				
				//GC gc = new GC(canvas); 
				
				Image image;
			if(canvas.getParent().getSize().x>400)
				   image = new Image(getDisplay(),"resources/rightGreen.png");
			else
				   image = new Image(getDisplay(),"resources/rightRed.png");

		     int imageWidth = image.getBounds().width;
		     int imageHeight = image.getBounds().height;
		     int width = canvas.getSize().x;
		     int height = canvas.getSize().y;

		 //Image scaled050 = new Image(getDisplay(),image.getImageData().scaledTo(width,height));
		// Image scaledGC200 = new Image(getDisplay(),width,height);    
		     e.gc.drawImage(image,0,0,imageWidth,imageHeight,0,0,width,height);
				
				  
					}
				      
				
		});
    	
 }

	}




