package translatorv3.taskspecific;

import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import translatorv3.domain.Context;
import translatorv3.domain.EenvoudigeZin;
import translatorv3.domain.Lidwoord;
import translatorv3.domain.Naamwoordelijkdeel;
import translatorv3.domain.Werkwoord;
import translatorv3.domain.Werkwoordelijkdeel;
import translatorv3.domain.Zelfstandignaamwoord;

public abstract class TaalExpression implements IWerkwoord, ILidwoord, IZelfstandignaamwoord{
	private Werkwoord ww = new Werkwoord("");
	private Lidwoord lw = new Lidwoord("");
	private Zelfstandignaamwoord zfnw = new Zelfstandignaamwoord("");

	public boolean interpret(Context context) {
		boolean result = false;
	if(interpretEenvoudigeZin(context)) {
		result = true;
	}
	 return result;
	}

	public Expression interpretZelfstandignaamwoord(String str) {
		 if(str.equalsIgnoreCase("brood")) { return brood(); }
		else if(str.equalsIgnoreCase("man")) { return man(); }
		else if(str.equalsIgnoreCase("boer")) { return boer(); }
		else { return null;	}
	}
	
	public Expression interpretWerkwoord(String str) {
		 if(str.equalsIgnoreCase("laat")) { return laat(); }
		else if(str.equalsIgnoreCase("eet")) { return eet(); }
		else if(str.equalsIgnoreCase("koopt")) { return koopt(); }
		else if(str.equalsIgnoreCase("snijdt")) { return snijdt(); }
		else { return null;	}
	}
	
	public Expression interpretLidwoord(String str) {
		if(str.equalsIgnoreCase("de")) { return de(); }
		else if(str.equalsIgnoreCase("een")) { return een(); }
		else if(str.equalsIgnoreCase("het")) { return het(); }
		else { return null;	}
	}
	
	public boolean interpretEenvoudigeZin(Context context) {
		boolean result = false;
		String errorMessage ="";
		StringTokenizer st = new StringTokenizer(context.getInput());

		if(st.countTokens() == 5) {
		if(interpretNaamwoordelijkdeel(context)) {
			if(interpretWerkwoordelijkdeel(context)) {
				if(interpretNaamwoordelijkdeel(context)){
					
					Naamwoordelijkdeel nm1 = null;
					Werkwoordelijkdeel wwd = null;
					Naamwoordelijkdeel nm2 = null;

					  Iterator it = context.getSentenceMap().entrySet().iterator();
					    while (it.hasNext()) {
					        Map.Entry pair = (Map.Entry)it.next();
					        if(pair.getValue().getClass().getSimpleName().equalsIgnoreCase("Naamwoordelijkdeel") && nm1 == null) 		{ 	nm1 = (Naamwoordelijkdeel) pair.getValue();       	}
					        else if(pair.getValue().getClass().getSimpleName().equalsIgnoreCase("Werkwoordelijkdeel")) 					{  	wwd = (Werkwoordelijkdeel) pair.getValue();	        }
					        else if(pair.getValue().getClass().getSimpleName().equalsIgnoreCase("Naamwoordelijkdeel") && nm1 != null) 	{  	nm2 = (Naamwoordelijkdeel) pair.getValue(); 		}
					       it.remove(); // avoids a ConcurrentModificationException
					    }

					if(nm1 != null && wwd != null && nm2 != null) {    
					EenvoudigeZin zin = new EenvoudigeZin(nm1, wwd, nm2);
					context.setSentence(zin);
					}
					else {
						System.out.println("nullpointer fout");
					}
					
					result = true;
				}else {
					errorMessage = "ERROR: Het 2e naamwoordelijkdeel komt niet in onze grammatica voor.";
					context.setOutput(errorMessage);
					context.setInput("");
				}
			}else {
				errorMessage = "ERROR: Het werkwoordelijkdeel komt niet in onze grammatica voor.";
				context.setOutput(errorMessage);
				context.setInput("");
			}
		}
		else {
			errorMessage = "ERROR: Het 1e naamwoordelijkdeel komt niet in onze grammatica voor.";
			context.setOutput(errorMessage);
			context.setInput("");
		}
		}
		else {
			errorMessage = "ERROR: Een eenvoudige zin bevat 5 woorden!";
			context.setOutput(errorMessage);
			context.setInput("");
		}
	return result;
	}
	
	public boolean interpretNaamwoordelijkdeel(Context context) {
			boolean result = false;
			
			StringTokenizer st = new StringTokenizer(context.getInput());
	    	String newInput ="";
	    	String newInput2 ="";
	  
		    Expression lw1 = lw.interpret(context); 
		    if(lw1 != null) {
		    Expression interpretedLidwoord = interpretLidwoord(lw1.getWoord());
		        
		        if(interpretedLidwoord != null) {
		        	st.nextToken();
		        	while(st.hasMoreTokens()) {
			    		 String word = st.nextToken();
		        		 newInput += word + " ";
			    	 }
		        	
		        	 context.setInput(newInput);
		        	
				     Expression zfnwEx = zfnw.interpret(context);
				     if(zfnwEx != null) {
				     Expression interpretedZfnw = interpretZelfstandignaamwoord(zfnwEx.getWoord());
					
				     StringTokenizer st2 = new StringTokenizer(context.getInput());

				     if(interpretedZfnw != null) {
				    	 st2.nextToken();
				    	 while(st2.hasMoreTokens()) {
				    		 String word = st2.nextToken();
			        		 newInput2 += word + " ";
				    	 }		    
				        	context.setInput(newInput2);
				        	Naamwoordelijkdeel nwd = new Naamwoordelijkdeel(interpretedLidwoord, interpretedZfnw);
	        		        if(nwd != null) {
	        		        context.addPartToSentence(nwd);
	        		        }
				      	  context.setOutput(context.getOutput() + interpretedLidwoord.getWoord()+ " " + interpretedZfnw.getWoord() + " ");
				      	  result = true;
				     }		     
				     
				     }
		        }	
	    	}
	        return result;
	}
	
	public boolean interpretWerkwoordelijkdeel(Context context) {
		boolean result = false;
     Expression werkwoord = ww.interpret(context);
     StringTokenizer st = new StringTokenizer(context.getInput());
 	 String newInput ="";
 	 
 	 if(werkwoord != null) {
      Expression interpretedWerkwoord = interpretWerkwoord(werkwoord.getWoord());
      if(interpretedWerkwoord != null) {
    	  context.setOutput(context.getOutput() + interpretedWerkwoord.getWoord()+ " ");
    	  st.nextToken();
    	  while(st.hasMoreTokens()) {
	    		 String word = st.nextToken();
      		 newInput += word + " ";	    		  
	    	 }
    	  context.setInput(newInput);
    	  
    	  Werkwoordelijkdeel wwd = new Werkwoordelijkdeel(interpretedWerkwoord);
	        if(wwd != null) {
	        context.addPartToSentence(wwd);
	        }
    	  result = true;
      }
      
	}
        return result;
	}
}

