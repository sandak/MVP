package GuiView;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class PossibleMoves extends Canvas {

	public PossibleMoves(Composite parent, int style) {
		super(parent, style);
		setBackground(new Color(null, 255, 255, 255));
		Canvas canvas = this;
    	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				

				if(canvas.getParent().getSize().x>400)
				{
					Image image = new Image(getDisplay(),"resources/rightGreen.png");
					//e.gc.drawImage(image, 0, 0);
					Image scaledGC = new Image(getDisplay(),(int)(canvas.getSize().x*0.1),(int)(canvas.getSize().y*0.1));
					//GC gc = new GC(scaledGC);
					e.gc.drawImage(image,0,0,canvas.getSize().x,canvas.getSize().y,0,0,(int)(canvas.getSize().x*1),(int)(canvas.getSize().x*1));
				}
				else
				{
					Image image = new Image(getDisplay(),"resources/rightRed.png");
					//e.gc.drawImage(image, 0, 0);
					Image scaledGC = new Image(getDisplay(),(int)(canvas.getSize().x*0.1),(int)(canvas.getSize().y*0.1));
					e.gc.drawImage(image,0,0,canvas.getSize().x,canvas.getSize().y,0,0,(int)(canvas.getSize().x*1),(int)(canvas.getSize().x*1));
				}
   
		    }
				
		});
    	
	}

}




