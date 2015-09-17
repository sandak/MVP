package view;

import java.util.HashMap;
import java.util.Observable;

import controller.Command;

public abstract class ObservableCommonView extends Observable implements View {

	@Override
	public void display(String[] strings) {
		// TODO Auto-generated method stub

	}
	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCommands(HashMap<String, Command> commandMap) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
