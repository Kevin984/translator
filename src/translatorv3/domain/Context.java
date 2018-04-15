package translatorv3.domain;

import java.util.HashMap;

import translatorv3.taskspecific.Expression;

public class Context {
private String input;
private String output;
private Expression sentenceExpression;
private HashMap<Integer, Expression> sentence = new HashMap<Integer, Expression>();

public Context(String input) {
	this.input = input;
	this.output = "";
}

public String getInput() {
	return input;
}

public String getOutput() {
	return output;
}

public void setInput(String input) {
	this.input = input;
}

public void setOutput(String output) {
	this.output = output;
}

public HashMap<Integer, Expression> getSentenceMap(){
	return sentence;
}

public Expression getSentence() {
	return sentenceExpression;
}
public void setSentence(Expression ex) {
	this.sentenceExpression = ex;
}

public void addPartToSentence(Expression ex) {
	int size = sentence.size();
	sentence.put(size+1, ex);
}

}
