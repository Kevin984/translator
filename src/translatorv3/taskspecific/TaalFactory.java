package translatorv3.taskspecific;

public class TaalFactory {
	public TaalExpression selectLanguage(String lang) {
		if(lang.equals("Engels")) {
			return new Engels();
		}
		else if(lang.equals("Italiaans")) {
			return new Italiaans();
		}
		else {
			return null;
		}
		
	}
}
