package org.LYG.GUI.OSGI;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.JInternalFrame;
public class objectPanel extends JInternalFrame implements Cloneable{
	private static final long serialVersionUID = 1L;
	public boolean close=false;
	public objectPanel addr;
	public ScrollPane jsp;
	public Panel jp;
	public int h;
	public int w;
	protected objectPanel(){	
	}
	public void config() {	
	}
	public objectPanel luoyaoguang() {  
		return addr;  
	}  

}
