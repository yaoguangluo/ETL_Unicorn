package org.LYG.GUI.nodeEdit;
import org.LYG.GUI.OSGI.ObjectInterface;
public class LinkNode extends Thread{ 
	public String nodeConfiguration= "";
	public String primaryKey= "";
	public int flash= 0;
	public Boolean beconnect;
	public Boolean leftChoose;
	public Boolean rightChoose;
	public Boolean tBeconnect;
	public int tBeconnectX;
	public int tBeconnectY;
	public String tBeconnetName;
	public String tBeconnectPrimaryKey= "";
	public int tBeconnectID;
	public Boolean mBeconnect;
	public int mBeconnectX;
	public int mBeconnectY;
	public String mBeconnetName;
	public String mBeconnectPrimaryKey= "";
	public int mBeconnectID;
	public Boolean dBeconnect;
	public int dBeconnectX;
	public int dBeconnectY;
	public String dBeconnetName;
	public String dBeconnectPrimaryKey= "";
	public int dBeconnectID;
	public String name;
	public LinkNode pre;
	public LinkNode next;
	public int ID;
	public int x, y;
	public ObjectInterface thisFace; 
	public LinkNode(){}
	public void addName(String thisName, int x1,int y1,int id1){
		beconnect= false;
		rightChoose= false;
		leftChoose= false;
		tBeconnect= false;
		mBeconnect= false;
		dBeconnect= false;
		x= x1;
		y= y1;
		name= new String(thisName);
		ID= id1;
		tBeconnectPrimaryKey= "";
		mBeconnectPrimaryKey= "";
		dBeconnectPrimaryKey= "";
		tBeconnectID= 0;
		mBeconnectID= 0;
		dBeconnectID= 0;
		primaryKey=""+ Math.random();
	}

	public void setxy(int x1,int y1){
		x= x1;
		y= y1;
	}

	public void setchoose(Boolean choose){
		leftChoose= choose;
	}
}
