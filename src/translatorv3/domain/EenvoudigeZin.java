package translatorv3.domain;

import java.util.HashMap;

import translatorv3.taskspecific.Expression;

public class EenvoudigeZin extends Expression {
	private Naamwoordelijkdeel nwd;
	private Naamwoordelijkdeel nwd2;
	private Werkwoordelijkdeel wwd;
	
	public EenvoudigeZin(Naamwoordelijkdeel nwd, Werkwoordelijkdeel wwd, Naamwoordelijkdeel nwd2) {
		this.nwd = nwd;
		this.wwd = wwd;
		this.nwd2 = nwd2;
	}

	@Override
	public String getWoord() {
		return null;
	}

	@Override
	public Expression interpret(Context context) {
		nwd.interpret(context);
		wwd.interpret(context);
		nwd2.interpret(context);
		Expression ex = new EenvoudigeZin(nwd, wwd, nwd2);
		return ex;
	}



	@Override
	public HashMap<String, Expression> getSubclasses() {
		HashMap<String, Expression> aa = new HashMap<String, Expression>();
		aa.put("1:"+ this.getClass().getSimpleName(), nwd);
		aa.put("2:"+this.getClass().getSimpleName(), wwd);
		aa.put("3:"+this.getClass().getSimpleName(), nwd2);
		return aa;
	}
	
	
}
