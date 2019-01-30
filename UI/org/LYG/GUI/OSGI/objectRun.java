package org.LYG.GUI.OSGI;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JPanel;
import javax.swing.JTable;

public class objectRun extends JPanel implements Cloneable{
	private static final long serialVersionUID = 1L;
	public objectRun addr;
	public JTable toptablein;
	public int[][] topgin;
	public AudioInputStream topaisin;

	public JTable midtablein;
	public int[][] midgin;
	public AudioInputStream midaisin;

	public JTable downtablein;
	public int[][] downgin;
	public AudioInputStream downaisin;
	public objectRun(){
	}
	@Override  
	public objectRun clone() {  
		return addr;  
	}
}
