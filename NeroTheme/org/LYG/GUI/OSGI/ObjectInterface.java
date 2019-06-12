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
	public String nodeConfiguration;
	public ObjectPanel thisPanel;
	public ObjectRun thisRun;
	public ObjectView thisView;
	public ObjectInterface thisInterface;
	public boolean showed= false;
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException
	, IOException  {
		return thisInterface;   
	}
	public ObjectInterface(){
		thisIcon= null;
		thisImage= null;
		thisName= null;
		thisPanel= new ObjectPanel();
		thisRun= new ObjectRun();
		thisView= new ObjectView();	
	}
	public void config(JTextPane rightBotJTextPane) throws IOException{
		//准备增加检查 nodeConfiguration 是否有配置
		//如果有，就自动配置，没有就弹出面板来操作配置。
		//写自动配置的 JSON String to MAP 函数 来取操作数 
		//罗瑶光注释：20190612
	}
	public void execute(JTextPane rightBotJTextPane) throws FileNotFoundException
	, IOException, UnsupportedAudioFileException, InterruptedException{
	}
	public void view(JTextPane rightBotJTextPane) throws Exception{
	}
}
