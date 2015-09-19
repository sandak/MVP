package GuiView;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PossibleMoves extends Canvas {

	public PossibleMoves(Composite parent, int style) {
		super(parent, style);
	
		setBackground(new Color(null, 255, 255, 255));
		Canvas canvas = this;
		canvas.setLayout(new GridLayout(3,false));
		Label title = new Label(canvas, SWT.TITLE);
		title.setText("Possible moves controller");
		title.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));
		new Arrow(canvas,"resources/upGreen.png","resources/upRed.png", SWT.FILL).setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Arrow(canvas,"resources/upGreen.png","resources/upRed.png", SWT.FILL).setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, true, 2, 1));
		new Arrow(canvas,"resources/downGreen.png","resources/downRed.png", SWT.FILL).setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 2));
		new Arrow(canvas,"resources/leftGreen.png","resources/leftRed.png", SWT.FILL).setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Arrow(canvas,"resources/rightGreen.png","resources/rightRed.png", SWT.FILL).setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Arrow(canvas,"resources/downGreen.png","resources/downRed.png", SWT.FILL).setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 1));
		
    	
 }

	}




