package translatorv3.domain;

import java.util.HashMap;
import java.util.StringTokenizer;

import translatorv3.taskspecific.Expression;
import translatorv3.taskspecific.IZelfstandignaamwoord;

public class Zelfstandignaamwoord extends Expression implements IZelfstandignaamwoord{
private String woord;
	

	public Zelfstandignaamwoord(String woord) {
		this.woord = woord;
	}
	public String getWoord() {
		return woord;
	}
	
	@Override
	public Expression interpret(Context context) {
		 StringTokenizer st = new StringTokenizer(context.getInput());
	        String str = st.nextToken();

		 if(str.equalsIgnoreCase("brood")) { return brood(); }
			else if(str.equalsIgnoreCase("man")) { return man(); }
			else if(str.equalsIgnoreCase("boer")) { return boer(); }
			else { return null;	}
	}
	@Override
	public HashMap<String, Expression> getSubclasses() {
		return null;
	}
	@Override
	public Zelfstandignaamwoord brood() {
		return new Zelfstandignaamwoord("brood");
	}
	@Override
	public Zelfstandignaamwoord man() {
		return new Zelfstandignaamwoord("man");
	}
	@Override
	public Zelfstandignaamwoord boer() {
		return new Zelfstandignaamwoord("boer");
	}
}
