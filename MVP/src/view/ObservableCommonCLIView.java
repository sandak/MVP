package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Observable;

public abstract class ObservableCommonCLIView extends Observable implements View {

	protected BufferedReader in;
	protected PrintWriter out;
	
	public ObservableCommonCLIView(BufferedReader in , PrintWriter out){		//Ctor
		this.in = in;
		this.out = out;
	}

}
