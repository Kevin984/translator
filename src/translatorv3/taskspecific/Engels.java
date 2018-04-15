package translatorv3.taskspecific;

import translatorv3.domain.Lidwoord;
import translatorv3.domain.Werkwoord;
import translatorv3.domain.Zelfstandignaamwoord;

public class Engels extends TaalExpression{

	@Override
	public Lidwoord de() {	return new Lidwoord("the");}
	@Override
	public Lidwoord het() {return new Lidwoord("it");}
	@Override
	public Lidwoord een() {return new Lidwoord("a");}
	@Override
	public Werkwoord laat() {return new Werkwoord("let");	}
	@Override
	public Werkwoord eet() { return new Werkwoord("eats");   }
	@Override
	public Werkwoord koopt() { return new Werkwoord("buys");	}
	@Override
	public Werkwoord snijdt() {return new Werkwoord("cuts");}
	@Override
	public Zelfstandignaamwoord brood() {return new Zelfstandignaamwoord("bread");}
	@Override
	public Zelfstandignaamwoord man() {	return new Zelfstandignaamwoord("man");	}
	@Override
	public Zelfstandignaamwoord boer() {return new Zelfstandignaamwoord("farmer");}


}
