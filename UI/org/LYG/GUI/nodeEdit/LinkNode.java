package org.LYG.GUI.nodeEdit;
import org.LYG.GUI.OSGI.objectInterface;
public class LinkNode extends Thread{ 
	public int flash=0;
	public Boolean beconnect;
	public Boolean leftchoose;
	public Boolean rightchoose;
	public Boolean tbeconnect;
	public int tbeconnectx;
	public int tbeconnecty;
	public String tbeconnetName;
	public int tbeconnectID;
	public Boolean mbeconnect;
	public int mbeconnectx;
	public int mbeconnecty;
	public String mbeconnetName;
	public int mbeconnectID;
	public Boolean dbeconnect;
	public int dbeconnectx;
	public int dbeconnecty;
	public String dbeconnetName;
	public int dbeconnectID;
	public String name;
	public LinkNode pre;
	public LinkNode next;
	public int ID;
	public int x,y;
	public objectInterface thisface; 
	public LinkNode(){}
	public void addName(String thisname, int x1,int y1,int id1){
		beconnect = false;
		rightchoose = false;
		leftchoose = false;
		tbeconnect = false;
		mbeconnect = false;
		dbeconnect = false;
		x = x1;
		y = y1;
		name = new String(thisname);
		ID = id1;
		tbeconnectID = 0;
		mbeconnectID = 0;
		dbeconnectID = 0;
	}
	public void setxy(int x1,int y1){
		x=x1;
		y=y1;
	}
	public void setchoose(Boolean choose1){
		leftchoose=choose1;
	}

}
