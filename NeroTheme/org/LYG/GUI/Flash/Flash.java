package org.LYG.GUI.Flash;
import javax.swing.JFrame;
import org.LYG.sets.stable.StableData;
public class Flash extends GUISample{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings(StableData.TAG_DEPRECATION)
	public static void main(String args[]){
		GUISample NE= new GUISample();
		JFrame frame= new JFrame("Deta ETL 1.0.2");   
        frame.setLayout(null);   
        frame.resize(800, 440);   
        frame.show();         
        frame.add(NE);   
        NE.init();
		NE.start();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}