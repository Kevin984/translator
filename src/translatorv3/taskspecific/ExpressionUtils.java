package translatorv3.taskspecific;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import translatorv3.domain.Context;
import translatorv3.domain.EenvoudigeZin;


public class ExpressionUtils  {
	private TaalExpression taalex;
	
	public ExpressionUtils(TaalExpression taalex) {
		this.taalex = taalex;
	}
	
	public ArrayList<String> eenvoudigeZinStructuur(Context context){
		taalex.interpret(context);
		ArrayList<String> structure = new ArrayList<String>();
		EenvoudigeZin zin = (EenvoudigeZin) context.getSentence();
		Iterator it = zin.getSubclasses().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Expression ex = (Expression) pair.getValue();
	        if(ex.getSubclasses().size() > 0) {
	        	Iterator it2 = ex.getSubclasses().entrySet().iterator();
	 		    while (it2.hasNext()) {
	 		        Map.Entry pair2 = (Map.Entry)it2.next();
	 		        structure.add(zin.getClass().getSimpleName() + " " + ex.getClass().getSimpleName() + " " + pair2.getValue().getClass().getSimpleName() + " " + pair2.getKey());
	 		        it2.remove(); // avoids a ConcurrentModificationException
	        }
	        }
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    return structure;
	}
}
