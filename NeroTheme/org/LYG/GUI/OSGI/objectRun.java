package org.LYG.GUI.OSGI;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JPanel;
import javax.swing.JTable;
//import movieProcessor.LYGFileIO;
public class objectRun extends JPanel implements Cloneable{
	private static final long serialVersionUID = 1L;
	public objectRun addr;
	public JTable toptablein;
	public Map<String, Integer> topMapIn;
	public int[][] topgin;
	public String topsin;
	public AudioInputStream topaisin;
	//	public LYGFileIO toplygin;

	public JTable midtablein;
	public int[][] midgin;
	public AudioInputStream midaisin;
	//	public LYGFileIO midlygin;

	public JTable downtablein;
	public int[][] downgin;
	public AudioInputStream downaisin;
	//	public LYGFileIO downlygin;
	public objectRun(){
	}
	@Override  
	public objectRun clone() {  
		return addr;  
	}
}
