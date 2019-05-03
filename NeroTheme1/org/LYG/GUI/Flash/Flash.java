package org.LYG.GUI.Flash;
import javax.swing.JFrame;
public class Flash extends GUIsample{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		GUIsample NE = new GUIsample();
		JFrame frame = new JFrame("Moon Base Alpha");   
        frame.setLayout(null);   
        frame.resize(800, 440);   
        frame.show();         
        frame.add(NE);   
        NE.init();
		NE.start();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}