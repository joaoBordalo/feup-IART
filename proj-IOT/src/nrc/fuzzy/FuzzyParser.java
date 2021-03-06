
//----------------------------------------------------
// The following code was generated by CUP v0.10i
// Sun Apr 11 11:20:05 EDT 1999
//----------------------------------------------------

package nrc.fuzzy;

import java_cup.runtime.*;

public class FuzzyParser extends java_cup.runtime.lr_parser {

  /** constructor */
  public FuzzyParser() {super();}

  /** production table */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\006\000\002\003\005\000\002\002\004\000\002\003" +
    "\005\000\002\003\003\000\002\003\004\000\002\003\005" +
    "" });

  /** access to production table */
  public short[][] production_table() {return _production_table;}

  /** parse action table */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\010\006\007\010\006\011\004\001\002\000" +
    "\012\002\ufffe\004\ufffe\005\ufffe\007\ufffe\001\002\000\010" +
    "\002\017\004\013\005\012\001\002\000\010\006\007\010" +
    "\006\011\004\001\002\000\010\006\007\010\006\011\004" +
    "\001\002\000\010\004\013\005\012\007\011\001\002\000" +
    "\012\002\ufffc\004\ufffc\005\ufffc\007\ufffc\001\002\000\010" +
    "\006\007\010\006\011\004\001\002\000\010\006\007\010" +
    "\006\011\004\001\002\000\012\002\uffff\004\uffff\005\uffff" +
    "\007\uffff\001\002\000\012\002\001\004\013\005\001\007" +
    "\001\001\002\000\012\002\ufffd\004\ufffd\005\ufffd\007\ufffd" +
    "\001\002\000\004\002\000\001\002" });

  /** access to parse action table */
  public short[][] action_table() {return _action_table;}

  /** reduce_goto table */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\004\003\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\003\015\001\001\000\004\003\007" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\003" +
    "\014\001\001\000\004\003\013\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** access to reduce_goto table */
  public short[][] reduce_table() {return _reduce_table;}

  /** instance of action encapsulation class */
  protected CUP$FuzzyParser$actions action_obj;

  /** action encapsulation object initializer */
  protected void init_actions()
    {
      action_obj = new CUP$FuzzyParser$actions(this);
    }

  /** invoke a user supplied parse action */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$FuzzyParser$do_action(act_num, parser, stack, top);
  }

  /** start state */
  public int start_state() {return 0;}
  /** start production */
  public int start_production() {return 1;}

  /** EOF Symbol index */
  public int EOF_sym() {return 0;}

  /** error Symbol index */
  public int error_sym() {return 1;}


  /** user initialization */
  public void user_init() throws java.lang.Exception
    {
 
    if (theScanner == null)
      report_fatal_error("No scanner was specified when the FuzzyParser was constructed", null);
    else
      theScanner.init();              

    }

  /** scan to get the next Symbol */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 
   if (theScanner == null)
     {
      report_fatal_error("No scanner was specified when the FuzzyParser was constructed", null);
      return new java_cup.runtime.Symbol(error_sym());
     }
   else
     return theScanner.next_token(); 

    }

 
    /* new constructor to allow the scanner to be specified at runtime 
       - without this sort of addition we cannot easily have multiple
         threads using the same parser
       - NOTE: should NOT use the parser constructor without arguments!
    */
    public FuzzyParser(FuzzyScanner fs) 
       { super();
         theScanner = fs;
       }

    /* Varaible that holds the fuzzy scanner */
    FuzzyScanner theScanner;

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$FuzzyParser$actions {
  private final FuzzyParser parser;

  /** Constructor */
  CUP$FuzzyParser$actions(FuzzyParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$FuzzyParser$do_action(
    int                        CUP$FuzzyParser$act_num,
    java_cup.runtime.lr_parser CUP$FuzzyParser$parser,
    java.util.Stack            CUP$FuzzyParser$stack,
    int                        CUP$FuzzyParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$FuzzyParser$result;

      /* select the action based on the action number */
      switch (CUP$FuzzyParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // lexpr ::= LPAREN lexpr RPAREN 
            {
              FuzzyValue RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).right;
		FuzzyValue e = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).value;
		 RESULT = e; 
              CUP$FuzzyParser$result = new java_cup.runtime.Symbol(1/*lexpr*/, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right, RESULT);
            }
          return CUP$FuzzyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // lexpr ::= FUZZYMODIFIER lexpr 
            {
              FuzzyValue RESULT = null;
		int fmodleft = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).left;
		int fmodright = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).right;
		String fmod = (String)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right;
		FuzzyValue e = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).value;
		 RESULT = Modifiers.call(fmod, e); 
              CUP$FuzzyParser$result = new java_cup.runtime.Symbol(1/*lexpr*/, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right, RESULT);
            }
          return CUP$FuzzyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // lexpr ::= FUZZYTERM 
            {
              FuzzyValue RESULT = null;
		int fvalleft = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).left;
		int fvalright = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right;
		FuzzyValue fval = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).value;
		 RESULT = fval; 
              CUP$FuzzyParser$result = new java_cup.runtime.Symbol(1/*lexpr*/, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right, RESULT);
            }
          return CUP$FuzzyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // lexpr ::= lexpr AND lexpr 
            {
              FuzzyValue RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).right;
		FuzzyValue e1 = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right;
		FuzzyValue e2 = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).value;
		 RESULT = e1.fuzzyIntersection(e2); 
              CUP$FuzzyParser$result = new java_cup.runtime.Symbol(1/*lexpr*/, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right, RESULT);
            }
          return CUP$FuzzyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= lexpr EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).right;
		FuzzyValue start_val = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).value;
		RESULT = start_val;
              CUP$FuzzyParser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$FuzzyParser$parser.done_parsing();
          return CUP$FuzzyParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // lexpr ::= lexpr OR lexpr 
            {
              FuzzyValue RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).right;
		FuzzyValue e1 = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right;
		FuzzyValue e2 = (FuzzyValue)((java_cup.runtime.Symbol) CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).value;
		 RESULT = e1.fuzzyUnion(e2); 
              CUP$FuzzyParser$result = new java_cup.runtime.Symbol(1/*lexpr*/, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$FuzzyParser$stack.elementAt(CUP$FuzzyParser$top-0)).right, RESULT);
            }
          return CUP$FuzzyParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

