package org.LYG.GUI.OSGI;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.JFrame;
public class ObjectPanel extends JFrame implements Cloneable{
	private static final long serialVersionUID= 1L;
	public boolean close= false;
	public ObjectPanel objectPanel;
	public ScrollPane scrollPane;
	public String textPane;
	public Panel panel;
	public int h;
	public int w;
	protected ObjectPanel(){	
	}
	public void config() {	
	}
	public ObjectPanel luoyaoguang() {  
		return objectPanel;
	}
}
