package view;

import java.util.HashMap;

import controller.Command;

public interface View {

	public void display(String[] strings);
	public void display(String string);
	public void setCommands(HashMap<String, Command> commandMap);
	public void exit() ;

}
