package gui;

import jess.*;
public class Launcher {

	private static Rete motor;
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws JessException {
		motor= new Rete();
		motor.batch("rules/iot.clp");
		motor.reset();
		
		motor.run();
		
	}

}
