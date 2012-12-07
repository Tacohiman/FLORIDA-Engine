package main;

import java.applet.Applet;
import java.awt.Graphics;

public class testo extends Applet{
	public static void grap(Graphics g){
		g.draw3DRect(1, 2, 4, 6, true);
	}
	public void paint (Graphics g){
	    g.drawString("Hello World!", 50, 25);
	 }
}
