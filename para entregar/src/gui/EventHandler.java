package gui;

//handler para mostrar o que fez disparar as regras e que regras dispararam e factos gerados
//da para fazer mais coisas
import jess.*;
import utilities.*;

public class EventHandler implements JessListener {
	
	MainMenu guiMenu;
	String smtpUsername;
	String smtpPassword;
	String email;
	String facebookToken;
	public EventHandler(MainMenu guiMainMenu) {
		guiMenu=guiMainMenu;
		smtpUsername=new String();
		smtpPassword=new String();
		email=new String();
		facebookToken=new String();
	}
	
    public void eventHappened(JessEvent je) throws JessException {
        int defaultMask = JessEvent.DEFRULE_FIRED | JessEvent.FACT | JessEvent.RESET;
        smtpUsername=guiMenu.getConfiguration().getEmailUsername();
		smtpPassword=guiMenu.getConfiguration().getEmailPassword();
		email=guiMenu.getConfiguration().getEmailEmail();
		facebookToken=guiMenu.getConfiguration().getFaceToken();
        int type = je.getType();
        switch (type) {
             case JessEvent.RESET:
            //  MyGUI.clearDisplay();
            	 //System.out.println(" reseted");
              break;

            case JessEvent.DEFRULE_FIRED:
              //MyGUI.displayCurrentRule( ((Activation) je.getObject()).getRule().getName());
            	System.out.println(((Activation) je.getObject()).getRule().getName());
              break;

            case JessEvent.REMOVED:
              //MyGUI.decrementFactCount();
              break;

            case JessEvent.FACT:
              //MyGUI.incrementFactCount();
            	Fact newFact = ((Fact) je.getObject());
            	System.out.println("New fact: " + newFact.getName());
            	
            	if(newFact.getName().equals("MAIN::envia-email"))
            	{
            		String mssg = newFact.get(0).toString().replace('-', ' ');
            		if(!smtpUsername.equals(""))
            		{
            		new EmailSSL("IOT NOTIFICATION", mssg, smtpUsername, smtpPassword, email);
            		System.out.println("msg sent to smtp server by handler");
            		}
            	}
            	
            	if(newFact.getName().equals("MAIN::envia-facebook"))
            	{
            		//o primeiro argumento e esta string que ]e o token do fb 
            		//ir buscar a https://developers.facebook.com/tools/explorer
            		String mssg = newFact.get(0).toString().replace('-', ' ');
            		if(!facebookToken.equals("")){
            		new FacebookPublisher(facebookToken, mssg);
            		System.out.println("msg published to fb by handler");
            		}
            	}
              break;

            default:
              // ignore
            	System.out.println(je.getSource().toString());
        }
    }
}
