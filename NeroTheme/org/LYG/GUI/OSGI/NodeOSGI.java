package org.LYG.GUI.OSGI;
import javax.swing.ImageIcon;
public class NodeOSGI{ 
	public NodeOSGI next;
	public NodeOSGI pre;
	public ObjectInterface currentFace;
	public ImageIcon thisIcon;
	public String thisName;
	@Override  
	public Object clone() {  
		NodeOSGI obj= null;  
		try{  
			obj= (NodeOSGI)super.clone();  
		}catch(CloneNotSupportedException e) {  
			e.printStackTrace();  
		}  
		return obj;  
	}  
	public NodeOSGI(){
		next= null;
		pre= null;
		currentFace= null;
		thisIcon= null;
		thisName= null;
	}
	public void addName(ObjectInterface thisface){
		next= null;
		pre= null;
		currentFace= thisface;
		thisIcon= currentFace.thisIcon;
		thisName= new String(currentFace.thisName);
	}
}