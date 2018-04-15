package translatorv3.taskspecific;

import java.util.HashMap;

import translatorv3.domain.Context;

public abstract class Expression {
	abstract public Expression interpret(Context context); 
	abstract public String getWoord();
	abstract public HashMap<String, Expression> getSubclasses();
}