package translatorv3.domain;

import java.util.HashMap;
import java.util.StringTokenizer;

import translatorv3.taskspecific.Expression;

public class Naamwoordelijkdeel extends Expression{
	private Expression lw;
	private Expression zfnw;
	
	public Naamwoordelijkdeel(Expression lw, Expression zfnw) {
		this.lw = lw;
		this.zfnw = zfnw;
	
	}
	
	public Expression getLidwoord() {
		return lw;
	}
	
	public Expression getZelfstandignaamwoord() {
		return zfnw;
	}
	

	@Override
	public String getWoord() {
		return null;
	}
	
	@Override
	public HashMap<String, Expression> getSubclasses() {
		HashMap<String, Expression> aa = new HashMap<String, Expression>();
		aa.put(lw.getWoord(), lw);
		aa.put(zfnw.getWoord(), zfnw);
		return aa;
	}

	@Override
	public Expression interpret(Context context) {
		return null;
	}
	
}
