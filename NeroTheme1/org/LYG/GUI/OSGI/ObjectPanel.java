package org.LYG.GUI.OSGI;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JInternalFrame;
public class ObjectPanel extends JInternalFrame implements Cloneable{
	private static final long serialVersionUID = 1L;
	public boolean close = false;
	public ObjectPanel addr;
	public ScrollPane jsp;
	public String textPane;
	public Panel jp;
	public int h;
	public int w;
	protected ObjectPanel(){	
	}
	public void config() {	
	}
	public ObjectPanel luoyaoguang() {  
		return addr;
	}
}
