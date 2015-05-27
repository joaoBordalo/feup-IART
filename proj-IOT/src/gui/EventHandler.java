package gui;

//handler para mostrar o que fez disparar as regras e que regras dispararam e factos gerados
//da para fazer mais coisas
import jess.*;

public class EventHandler implements JessListener {
    public void eventHappened(JessEvent je) {
        int defaultMask = JessEvent.DEFRULE_FIRED | JessEvent.FACT | JessEvent.RESET;
        int type = je.getType();
        switch (type) {
             case JessEvent.RESET:
            //  MyGUI.clearDisplay();
            	 System.out.println("limpando (reset)");
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
            	System.out.println("New fact: " + ((Fact) je.getObject()).getName());
              break;

            default:
              // ignore
            	System.out.println(je.getSource().toString());
        }
    }
}
