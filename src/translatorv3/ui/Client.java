package translatorv3.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import translatorv3.domain.Context;
import translatorv3.taskspecific.ExpressionUtils;
import translatorv3.taskspecific.TaalExpression;
import translatorv3.taskspecific.TaalFactory;

public class Client {

	public static void main(String[] args) {
		JFrame f=new JFrame("Vertalingsprogramma"); 
		String[] languages = {"","Engels","Italiaans"};

		//translate button
		JButton vertalenButton=new JButton("Vertalen");    
		vertalenButton.setBounds(380,40,140, 40);   
		
		JButton structuurButton=new JButton("Structuur");    
		structuurButton.setBounds(220,40,140, 40);   
		
		JLabel translatedSentence = new JLabel();
		translatedSentence.setText("Vertaal naar het: ");
		translatedSentence.setBounds(10, 10, 100, 100);
		
		// language selector
		JComboBox selectListTalen = new JComboBox(languages);
		selectListTalen.setBounds(110,50,100,20);
		
		JLabel label = new JLabel();		
		label.setText("Vertaal zin:");
		label.setBounds(10, 60, 100, 100);
		
		JLabel label1 = new JLabel();
		label1.setBounds(10, 100, 500, 100);
		
				//input field
		JTextField sentenceInput= new JTextField();
		sentenceInput.setBounds(110, 100, 410, 30);
				//add to frame
		f.add(label1);
		f.add(sentenceInput);
		f.add(label);
		f.add(vertalenButton);
		f.add(structuurButton);
		f.add(translatedSentence);
		f.add(selectListTalen);
		f.setSize(600,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
						//action listener
		vertalenButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String sentence = sentenceInput.getText();
			Context context = new Context(sentence);
			String selectedLang = selectListTalen.getSelectedItem().toString();
			 TaalFactory langFact = new TaalFactory();
		      TaalExpression exp = null;
		      exp = langFact.selectLanguage(selectedLang);
		      
		      if(exp != null) {
		    	  exp.interpret(context);
		    	  label1.setText("Vertaling: " + context.getOutput());
			      System.out.println(sentence + " = " + (context.getOutput()));
		      }
		      else {
		    	  label1.setText("Geen taal geselecteerd!");
		      }
		      
			}					
		});
		
		structuurButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sentence = sentenceInput.getText();
				Context context = new Context(sentence);
				
				String selectedLang = selectListTalen.getSelectedItem().toString();
				 TaalFactory langFact = new TaalFactory();
			      TaalExpression exp = null;
			      exp = langFact.selectLanguage(selectedLang);
			      
			      
				if(selectListTalen.getSelectedItem().toString() == "") {
			    	  label1.setText("Geen taal geselecteerd!");

				}
				
				else if(exp.interpret(context) == false) {
			    	  label1.setText("Grammatica klopt niet!");

				}
				else {
				JFrame f=new JFrame("Structuur"); 
			      if(exp != null) {
			  		ExpressionUtils exU = new ExpressionUtils(exp);

			    	//  exp.interpret(context);
			    	 ArrayList<String> aa2 =  exU.eenvoudigeZinStructuur(context);
			    	 int vertical= 0;
			    	 for(String s : aa2) {
			    		 JLabel label = new JLabel();		
			    			label.setText(s);
			    			label.setBounds(100, vertical+30, 1400, 100);
			    			vertical +=30;
			    			f.add(label);
			    	 }
			      }
			      
				f.setSize(600,300);    
				f.setLayout(null);    
				f.setVisible(true);    
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
				}
			}
			
		});
		}         
		}