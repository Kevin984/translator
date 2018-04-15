package translatorv3.taskspecific;

import translatorv3.domain.Lidwoord;
import translatorv3.domain.Werkwoord;
import translatorv3.domain.Zelfstandignaamwoord;

public class Italiaans extends TaalExpression{

	@Override
	public Lidwoord de() {	return new Lidwoord("il");}
	@Override
	public Lidwoord het() {return new Lidwoord("esso");}
	@Override
	public Lidwoord een() {return new Lidwoord("la");}
	@Override
	public Werkwoord laat() {return new Werkwoord("lasciare");	}
	@Override
	public Werkwoord eet() { return new Werkwoord("mangia");   }
	@Override
	public Werkwoord koopt() { return new Werkwoord("comprare");	}
	@Override
	public Werkwoord snijdt() {return new Werkwoord("tagliare");}
	@Override
	public Zelfstandignaamwoord brood() {return new Zelfstandignaamwoord("pane");}
	@Override
	public Zelfstandignaamwoord man() {	return new Zelfstandignaamwoord("uomo");	}
	@Override
	public Zelfstandignaamwoord boer() {return new Zelfstandignaamwoord("contadino");}

}
