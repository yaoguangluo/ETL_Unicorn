package org.LYG.GUI.OSGI;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
public class objectView extends JInternalFrame implements Cloneable{
	private static final long serialVersionUID = 1L;
	public objectView addr;
	public ScrollPane jsp;
	public Panel jp;
	public int h;
	public int w;
	public boolean close=false;
	public JTable tableout;
	public int[][] gout;
	public AudioInputStream aisout;
	public AudioInputStream aiscurout;
	//public BufferedImage imageout;
	public objectView() {
	}
	public void view() throws Exception{
	}
	public objectView clone() {  	
		return addr;  
	}  
}