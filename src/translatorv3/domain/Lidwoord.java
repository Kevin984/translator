package translatorv3.domain;

import java.util.HashMap;
import java.util.StringTokenizer;

import translatorv3.taskspecific.Expression;
import translatorv3.taskspecific.ILidwoord;

public class Lidwoord extends Expression implements ILidwoord{
	private String woord;
	
	
	public Lidwoord(String woord) {
		this.woord = woord;
	}
	
	public String getWoord() {
		return woord;
	}
	
	@Override
	public Expression interpret(Context context) {
        StringTokenizer st = new StringTokenizer(context.getInput());
        String str = st.nextToken();
        if(str.equalsIgnoreCase("de")) { return de(); }
		else if(str.equalsIgnoreCase("een")) { return een(); }
		else if(str.equalsIgnoreCase("het")) { return het(); }
		else { return null;	}
        /*
        if(st.countTokens() > 0) {
        	String word = st.nextToken();
        	if(word.equals(woord)) {
        		
        		context.setInput(st.nextToken());
        		while(st.hasMoreTokens()) {
        			String word2 = st.nextToken();
        			context.setInput(context.getInput() + " " + word2);
        		}        		
        		context.setOutput(woord+" ");
        	}
        }*/
	}

	@Override
	public HashMap<String, Expression> getSubclasses() {
		return null;
	}

	@Override
	public Lidwoord de() {
		return new Lidwoord("de");
	}

	@Override
	public Lidwoord het() {
		return new Lidwoord("het");
	}

	@Override
	public Lidwoord een() {
		return new Lidwoord("een");
	}
}
