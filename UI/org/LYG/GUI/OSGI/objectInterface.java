package org.LYG.GUI.OSGI;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
public class objectInterface implements Cloneable{
	public ImageIcon thisicon;
	public Image thisimage;
	public String thisname;
	public String position; 
	public objectPanel thispanel;
	public objectRun thisrun;
	public objectView thisview;
	public objectInterface stu;
	public boolean showed=false;
	public objectInterface luoyaoguang() throws CloneNotSupportedException, IOException  {
		return stu;   
	}
	public objectInterface(){
		thisicon=null;
		thisimage=null;
		thisname=null;
		thispanel=new objectPanel();
		thisrun=new objectRun();
		thisview=new objectView();	
	}
	public void config() throws IOException{
	}
	public void execute() throws FileNotFoundException, IOException, UnsupportedAudioFileException, InterruptedException{
	}
	public void view() throws Exception{
	}
}
