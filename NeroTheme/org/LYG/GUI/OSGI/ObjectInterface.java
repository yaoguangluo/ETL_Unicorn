package org.LYG.GUI.OSGI;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
public class ObjectInterface implements Cloneable{
	public ImageIcon thisIcon;
	public Image thisImage;
	public String thisName;
	public String position; 
	public ObjectPanel thisPanel;
	public ObjectRun thisRun;
	public ObjectView thisView;
	public ObjectInterface thisInterface;
	public boolean showed = false;
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException  {
		return thisInterface;   
	}
	public ObjectInterface(){
		thisIcon = null;
		thisImage = null;
		thisName = null;
		thisPanel = new ObjectPanel();
		thisRun = new ObjectRun();
		thisView = new ObjectView();	
	}
	public void config(JTextPane rightBotJTextPane) throws IOException{
	}
	public void execute(JTextPane rightBotJTextPane) throws FileNotFoundException, IOException, UnsupportedAudioFileException, InterruptedException{
	}
	public void view(JTextPane rightBotJTextPane) throws Exception{
	}
}
