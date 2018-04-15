package translatorv3.domain;

import java.util.HashMap;

import translatorv3.taskspecific.Expression;

public class Werkwoordelijkdeel extends Expression{
	private Expression werkwoord;
	
	public Werkwoordelijkdeel(Expression werkwoord) {
		this.werkwoord = werkwoord;
	}


	@Override
	public String getWoord() {
		return null;
	}

	@Override
	public Expression interpret(Context context) {
		return null;
	}


	@Override
	public HashMap<String, Expression> getSubclasses() {
		HashMap<String, Expression> aa = new HashMap<String, Expression>();
		aa.put(werkwoord.getWoord(), werkwoord);
		return aa;
	}
	
	

}
