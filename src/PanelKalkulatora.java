import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/** klasa reprezentuj¹ca panel kalkulatora, który zawiera wszystkie glowne komponenty
 * @author jstecz
 * version 0.1*/
class PanelKalkulatora extends JPanel 
{
 
    static int operacja; 		// (na pier. pozycji jest kod operacji, na drugiej miejsce w ³¹ñcuchu znaków) 0 - nie zdefiniowano operacji 
    //1 - dodawanie 2 - odejmowanie 3-mnozenie 4 - dzielenie 

    static boolean czyJestKropka = false;  				// informacja czy wstawiono kropkê
    static boolean czyJestWartWPamiec = false;  		// informacja czy w pamiêci pomocniczej jest wartoœæ
    static double wartoscPamieci;						// wartoœæ pomocnicza
    static double wartoscOkna;							// wartoœæ z okna
    static double ostatniaWartoscOkna;	              //dla potrzeb operacji rowna sie
    private JButton button1, button2, button3, button4, button5, button6, button7,button8, button9, button0;
    private JButton pDodawanie, pOdejmowanie, pMnozenie, pDzielenie, buttonRownania, pKasowanie, pKasowanieOstatniej, buttonKropka;
    private JTextField OknoWynik;
    
    /** Konstruktor panelu kalkulatora
     * W tym miejscu zostaly dodane wszystkie komponenty do panelu
     * ustalone zostalo rozmieszczenie komponentow oraz komponentom przypisano sluchacza zdarzen
	 * */
    PanelKalkulatora()
    {
       super();
       
       // Wy³¹czanie automatycznego pozycjonowania komponentów
       setLayout( null );     				
 
       // Utworzenie komponentów i dodanie ich do panelu okna
       OknoWynik = new JTextField("");
       button1 = new JButton( "1" );
       button2 = new JButton( "2" );
       button3 = new JButton( "3" ); 
       button4 = new JButton( "4" );
       button5 = new JButton( "5" );
       button6 = new JButton( "6" );
       button7 = new JButton( "7" );
       button8 = new JButton( "8" );
       button9 = new JButton( "9" );
       button0 = new JButton( "0" );
       buttonKropka = new JButton( "." );
       buttonRownania = new JButton("=");
       pDodawanie = new JButton("+");
       pOdejmowanie = new JButton("-");
       pMnozenie = new JButton("*");
       pDzielenie = new JButton("/");
       pKasowanie = new JButton("C");
       pKasowanieOstatniej = new JButton("Del");
       OknoWynik.setBounds(25,25,380,50);
       button1.setBounds( 25, 100, 80, 40 );
       button2.setBounds( 125, 100, 80, 40 );
       button3.setBounds( 225, 100, 80, 40 ); 
       button4.setBounds( 25, 150, 80, 40 );
       button5.setBounds( 125, 150, 80, 40 );
       button6.setBounds( 225, 150, 80, 40 );
       button7.setBounds( 25, 200, 80, 40 );
       button8.setBounds( 125, 200, 80, 40 );
       button9.setBounds( 225, 200, 80, 40 );
       button0.setBounds( 125, 250, 80, 40 );
       pKasowanie.setBounds(25,250,80, 40);
       buttonRownania.setBounds(125,300,80, 40);
       pDodawanie.setBounds(325,100,80, 40);
       pOdejmowanie.setBounds(325,150,80, 40);
       pMnozenie.setBounds(325,200,80, 40);
       pDzielenie.setBounds(325,250,80, 40);
       pKasowanieOstatniej.setBounds(25,300,80, 40);
       buttonKropka.setBounds(225,250,80, 40);
       Font font = new Font("arial", Font.PLAIN,25);
       OknoWynik.setFont(font);
       
       
       OknoWynik.setText("");
       OknoWynik.setEditable(false);
       OknoWynik.setHorizontalAlignment(JTextField.RIGHT);
       
       add( button1 );
       add( button2 );
       add( button3 );
       add (button4);
       add (button5);
       add (button6);
       add (button7);
       add (button8);
       add (button9);
       add (button0);
       add (buttonRownania);
       add (pDodawanie);
       add (pOdejmowanie);
       add (pMnozenie);
       add (pDzielenie);
       add (OknoWynik);
       add (pKasowanie);
       add (pKasowanieOstatniej);
       add(buttonKropka);
    
       
       Sluchacz sluchacz = new Sluchacz();
       // Dodawanie s³uchacza zdarzeñ - tego samego dla wszystkich przycisków
       button1.addActionListener( sluchacz );
       button2.addActionListener( sluchacz );
       button3.addActionListener( sluchacz );   
       button4.addActionListener( sluchacz );
       button5.addActionListener( sluchacz );
       button6.addActionListener( sluchacz );
       button7.addActionListener( sluchacz );
       button8.addActionListener( sluchacz );
       button9.addActionListener( sluchacz );
       button0.addActionListener( sluchacz );
       pDodawanie.addActionListener( sluchacz );
       pOdejmowanie.addActionListener( sluchacz );
       pMnozenie.addActionListener( sluchacz );
       pDzielenie.addActionListener( sluchacz );
       buttonRownania.addActionListener(sluchacz);
       pKasowanie.addActionListener( sluchacz );
       pKasowanieOstatniej.addActionListener( sluchacz );
       buttonKropka.addActionListener( sluchacz );
      
    }

    /** Klasa Sluchacz implementujaca interfejs ActionListener oraz metode actionPerformed
	 * */
  
   class Sluchacz implements ActionListener {

	   public void actionPerformed( ActionEvent evt)
	   {
		   	if (evt.getSource() != pDodawanie&& evt.getSource() != pOdejmowanie && evt.getSource() != pMnozenie&& evt.getSource () != pDzielenie
		   			&& evt.getSource() != pKasowanie && evt.getSource() != pKasowanieOstatniej 
		            && evt.getSource () != buttonKropka&& evt.getSource () != buttonRownania) 
		   	{
	            	if (evt.getSource() == button0 || evt.getSource() == button1 || evt.getSource() == button2 || evt.getSource() == button3 ||
	            		evt.getSource() == button4 || evt.getSource() == button5 || evt.getSource() == button6 || evt.getSource() == button7 ||
	            		evt.getSource() == button8 || evt.getSource() == button9) {
	            		
	            		String pom = ((JButton) evt.getSource()).getText(); 
	            		String wOknie;
	            		try {
	            			wOknie = OknoWynik.getText();
	            			if(wOknie.charAt(0)=='0'||(wOknie.charAt(0)=='0'& wOknie.charAt(1)!='.')) {wOknie=wOknie.substring(1);};
	            		}
	            		catch (Exception e) {wOknie = OknoWynik.getText();};
	            		OknoWynik.setText(wOknie + pom);
	            	
	            		            	};
            		System.out.println(OknoWynik.getText());
		    }
		   	else if (evt.getSource() == buttonKropka)
			{
        		String wOknie = OknoWynik.getText();
        			if (wOknie.indexOf(".")==-1) {
        				wOknie = wOknie+'.';
        				OknoWynik.setText(wOknie);
		   				};
			}
		   	else if (evt.getSource() == buttonRownania&& operacja!=0) {
		   		try {
	   				wartoscOkna = Double.parseDouble(OknoWynik.getText());
	   			}
	   			catch (Exception e) {
	   				wartoscOkna = 0.0;
	   			};
		   		
	   			double wynik;
	   			if (czyJestWartWPamiec == true) {
		   			wynik = wykonajOperacje(operacja, wartoscOkna, wartoscPamieci);
		   			ostatniaWartoscOkna = wartoscOkna;
	   			}
	   			else {
	   				wynik= wykonajOperacje(operacja, ostatniaWartoscOkna, wartoscOkna);
	   			};
		   			czyJestWartWPamiec = false;
		   			wartoscPamieci=0.0;
		   			wartoscOkna=wynik;
		   			OknoWynik.setText(Double.toString(wynik));
		   			String cmd = evt.getActionCommand();
			   		loguj(cmd,wartoscPamieci,wartoscOkna,operacja);
		   		}	
		   		
		   	

		   	else if (evt.getSource() == pDodawanie || evt.getSource() == pOdejmowanie || evt.getSource() == pMnozenie || evt.getSource() == pDzielenie)
			{
		   		//boolean czyJestZnak = sprawdzFormule(OknoWynik.getText()); 
		   		if (czyJestWartWPamiec == false && operacja == 0) {
		   			try {
		   				wartoscOkna = Double.parseDouble(OknoWynik.getText());
		   			}
		   			catch (Exception e) {
		   				wartoscOkna = 0.0;
		   			};
		   			wartoscPamieci = wartoscOkna; 
		   			wartoscOkna = 0;
		   			czyJestWartWPamiec = true;
		   			OknoWynik.setText("0");
			   		if (evt.getSource() == pDodawanie) {operacja = 1;}
			   		else if (evt.getSource() == pOdejmowanie) {operacja = 2;}
			   		else if (evt.getSource() == pMnozenie) {operacja = 3;}
			   		else if (evt.getSource() == pDzielenie) {operacja = 4;}	
			   		String cmd = evt.getActionCommand();
			   		loguj(cmd,wartoscPamieci,wartoscOkna,operacja);
		   		}		   		
		   		
		   		else if (czyJestWartWPamiec == true && operacja == 0) {
		   			try {
		   				wartoscOkna = Double.parseDouble(OknoWynik.getText());
		   			}
		   			catch (Exception e) {
		   				wartoscOkna = 0.0;
		   			};
		   			double wynik =wykonajOperacje(operacja, wartoscOkna, wartoscPamieci);
			   		if (evt.getSource() == pDodawanie) {operacja = 1;}
			   		else if (evt.getSource() == pOdejmowanie) {operacja = 2;}
			   		else if (evt.getSource() == pMnozenie) {operacja = 3;}
			   		else if (evt.getSource() == pDzielenie) {operacja = 4;}	
			   		czyJestWartWPamiec = true;
			   		wartoscPamieci=wynik;
			   		wartoscOkna = 0.0;
			   		OknoWynik.setText("0");
			   		String cmd = evt.getActionCommand();
			   		loguj(cmd,wartoscPamieci,wartoscOkna,operacja);
		   		}
		   		else if (czyJestWartWPamiec == true && operacja != 0) {
		   			try {
		   				wartoscOkna = Double.parseDouble(OknoWynik.getText());
		   			}
		   			catch (Exception e) {
		   				wartoscOkna = 0.0;
		   			};
		   			double wynik= wykonajOperacje(operacja, wartoscOkna, wartoscPamieci);
		   			if (evt.getSource() == pDodawanie) {operacja = 1;}
			   		else if (evt.getSource() == pOdejmowanie) {operacja = 2;}
			   		else if (evt.getSource() == pMnozenie) {operacja = 3;}
			   		else if (evt.getSource() == pDzielenie) {operacja = 4;}	
		   			czyJestWartWPamiec = true;
		   			wartoscPamieci = wynik;
		   			OknoWynik.setText("0");
		   			String cmd = evt.getActionCommand();
			   		loguj(cmd,wartoscPamieci,wartoscOkna,operacja);

		   		}
		   		else if (czyJestWartWPamiec == false && operacja != 0) {
		   			try {
		   				wartoscOkna = Double.parseDouble(OknoWynik.getText());
		   			}
		   			catch (Exception e) {
		   				wartoscOkna = 0.0;
		   			};
		   			wartoscPamieci = wartoscOkna;
		   			wartoscOkna=0;
		   			czyJestWartWPamiec= true;
		   			OknoWynik.setText("0");
		   			if (evt.getSource() == pDodawanie) {operacja = 1;}
			   		else if (evt.getSource() == pOdejmowanie) {operacja = 2;}
			   		else if (evt.getSource() == pMnozenie) {operacja = 3;}
			   		else if (evt.getSource() == pDzielenie) {operacja = 4;}	
		   			String cmd = evt.getActionCommand();
			   		loguj(cmd,wartoscPamieci,wartoscOkna,operacja);	
		   				
		   			
		   		};
		   			
		   			
			}

		   	else if (evt.getSource() == pKasowanie)
			{
		   		String cmd = evt.getActionCommand();
		   		System.out.println(cmd); // tak mo¿na pobraæ liczbê
	   			OknoWynik.setText("0");
	   			czyJestKropka = false;
	   			wartoscPamieci=0;
	   			wartoscOkna=0;
	   			czyJestWartWPamiec=false;
	   			
			}
		   	else if (evt.getSource() == pKasowanieOstatniej)
			{
	   			String pom = OknoWynik.getText(); 
	   			if (pom.length() > 0) {
			   		System.out.println("--> "+pom.substring(pom.length()-1));
		   			if  ( pom.charAt(pom.length()-1) == '.' ) { //(pom.substring(pom.length()-1).equals(".")) {
		   				czyJestKropka = false;
				   		System.out.println(" --> usuwam kropkê");  
		   			};
	   				pom = pom.substring(0, pom.length()-1);
		   			OknoWynik.setText(pom);
	   			};
			}
		   	
	  	}    
	
	   public void loguj(String komenda, double pamiec, double okno, int operacja) {
	   		System.out.println("operacja       : "+ komenda +" "+operacja);
	   		System.out.println("wart.pamiêci --> "+ pamiec);
	   		System.out.println("wart.okna    --> "+ okno);
	   };
	   /** Metoda wykonujaca operacje na liczbach 
	    * @param operacja oznacza rodzaj operacj do wykonania, czyli dodawanie, odejmowanie, mnozenie lub dzielenie
	    * @param wartosc okna oznacza liczbe wcisnieta po wcisnietym znaku operacji
	    * @param wartoscPamieci oznacza liczbe wprowdzona przed wcisnieciem znaku operacji, ktora tu przechowujemy 
		 * */
	   
	   public double wykonajOperacje(int operacja, double wartoscOkna, double wartoscPamieci) {
		   double w = 0.0;
		   
		   if     (operacja==1) {w= wartoscOkna +wartoscPamieci;}
		   else if(operacja==2) {w= wartoscPamieci-wartoscOkna;}
		   else if(operacja==3) {w= wartoscOkna *wartoscPamieci;}
		   else if(operacja==4) {w= wartoscPamieci/wartoscOkna;}
		   
		  return w;
		   
	   }
	   
   }
   public void paintComponent( Graphics g)
   {
       super.paintComponent(g);
   }
  
  
}


 
