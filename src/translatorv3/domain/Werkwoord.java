package translatorv3.domain;

import java.util.HashMap;
import java.util.StringTokenizer;

import translatorv3.taskspecific.Expression;
import translatorv3.taskspecific.IWerkwoord;

public class Werkwoord extends Expression implements IWerkwoord{
private String woord;

public Werkwoord(String woord) {
	this.woord = woord;
}

	public String getWoord() {
		return woord;
	}

	
	public Expression interpret(Context context) {
		StringTokenizer st = new StringTokenizer(context.getInput());
		String str = st.nextToken();
		 if(str.equalsIgnoreCase("laat")) { return laat(); }
			else if(str.equalsIgnoreCase("eet")) { return eet(); }
			else if(str.equalsIgnoreCase("koopt")) { return koopt(); }
			else if(str.equalsIgnoreCase("snijdt")) { return snijdt(); }
			else { return null;	}
	}

	@Override
	public HashMap<String, Expression> getSubclasses() {
		return null;
	}

	@Override
	public Werkwoord laat() {
		return new Werkwoord("laat");
	}

	@Override
	public Werkwoord eet() {
		return new Werkwoord("eet");

	}

	@Override
	public Werkwoord snijdt() {
		return new Werkwoord("snijdt");

	}

	@Override
	public Werkwoord koopt() {
		return new Werkwoord("koopt");

	}
}
