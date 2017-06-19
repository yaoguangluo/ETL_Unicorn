package org.LYG.GUI.OSGI;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JPanel;
import javax.swing.JTable;

import movieProcessor.lygFileIO;
public class objectRun extends JPanel implements Cloneable
{
	private static final long serialVersionUID = 1L;
	public objectRun addr;
	public JTable toptablein;
	public int[][] topgin;
	public AudioInputStream topaisin;
	public lygFileIO toplygin;
	
	public JTable midtablein;
	public int[][] midgin;
	public AudioInputStream midaisin;
	public lygFileIO midlygin;
	
	public JTable downtablein;
	public int[][] downgin;
	public AudioInputStream downaisin;
	public lygFileIO downlygin;
	public objectRun()
 	{
 	}
	@Override  
	public objectRun clone() {  
	        return addr;  
	}
}
