package gui;

import java.util.Scanner;

import nrc.fuzzy.jess.FuzzyRete;
import jess.*;
public class Launcher {

	private static Rete motor;
	/**
	 * @param args
	 */
	
	public static void main(String[] args)  throws JessException {
		
		
		Scanner scanner = new Scanner(System.in);
		try {
			FuzzyRete engine = new FuzzyRete();  
		MainMenu mainMenu = new MainMenu(engine);
		mainMenu.setVisible(true);
		 
		
			      
			engine.batch("rules/iot.clp");
			engine.reset();
		
		 engine.addJessListener(new EventHandler(mainMenu));
		 engine.setEventMask(engine.getEventMask() | JessEvent.DEFRULE_FIRED | JessEvent.FACT | JessEvent.RESET );
		 
		 
		 
		 //command line interface (da jeito pa ver como estao as coisas, ]e so mandar para la comandos de jess directo)
		
		 while(true)
		 {
			 System.out.print("Engine Prompt>");
			
			 String input=scanner.nextLine();
			 if(input.equals("exit"))
			 {
				 break;	 
			 }
			 else
			 {
			 engine.eval(input);
			 
			 //engine.run();	
			 
			 }
			 
		 }
		 //scanner.close();
		}
		catch (JessException je) 
		{ 
			System.err.println(je);
			
			Launcher.main(null);
		}
		finally
		{
			 scanner.close();
		}

		
	}

}
