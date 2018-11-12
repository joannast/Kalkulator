
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/** Klasa tworzaca ramke kalkulatora
 * */
public class Kalkulator extends JFrame {
 
    public static void main(String[] args) 
    {
        Kalkulator wnd = new Kalkulator();
        wnd.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        wnd.setBounds( 70, 70, 440, 400);
        wnd.setResizable(false);
        wnd.setTitle( "Kalkulator" );
        Container kontener = wnd.getContentPane();
        kontener.add(new PanelKalkulatora());
        wnd.setVisible(true);
      }
           
}	    
    	 
    	     

 
