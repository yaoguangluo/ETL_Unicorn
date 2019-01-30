package org.LYG.GUI.OSGI;
import javax.swing.ImageIcon;
public class nodeOSGI{ 
	public nodeOSGI next;
	public nodeOSGI pre;
	public objectInterface currentFace;
	public ImageIcon thisicon;
	public String thisname;
	@Override  
	public Object clone() {  
		nodeOSGI obj = null;  
		try{  
			obj = (nodeOSGI)super.clone();  
		}catch(CloneNotSupportedException e) {  
			e.printStackTrace();  
		}  
		return obj;  
	}  
	public nodeOSGI(){
		next=null;
		pre=null;
		currentFace=null;
		thisicon=null;
		thisname=null;
	}
	public void addName(objectInterface thisface){
		next=null;
		pre=null;
		currentFace=thisface;
		thisicon=currentFace.thisicon;
		thisname=new String(currentFace.thisname);
	}
}
