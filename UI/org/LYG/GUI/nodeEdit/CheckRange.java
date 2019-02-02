package org.LYG.GUI.nodeEdit;
import java.awt.event.MouseEvent;
public class CheckRange{
	public CheckRange(LinkNode first,LinkNode node, MouseEvent arg0) {
		first=new Sort().sort(first);
		LinkNode node1=new LinkNode();
		node1=first;
		if(node1!=null){
			int x,y;
			x=arg0.getX();
			y=arg0.getY();
			if((x>node1.x-20)&&(x<node1.x+50)&&(y>node1.y)&&(y<node1.y+16)&&(node.ID!=node1.ID)){
				node1.beconnect=true;
				node1.tbeconnect=true;
				node1.tbeconnectx=node.x;
				node1.tbeconnecty=node.y;
				node1.tbeconnectID=node.ID;
				node1.tbeconnetName=new String(node.name);
				return;
			}
			if((x>node1.x-20)&&(x<node1.x+50)&&(y>node1.y+16)&&(y<node1.y+32)&&(node.ID!=node1.ID)){
				node1.beconnect=true;
				node1.mbeconnect=true;
				node1.mbeconnectx=node.x;
				node1.mbeconnecty=node.y;
				node1.mbeconnectID=node.ID;
				node1.mbeconnetName=new String(node.name);
				return;
			}	
			if((x>node1.x-20)&&(x<node1.x+50)&&(y>node1.y+32)&&(y<node1.y+50)&&(node.ID!=node1.ID)){
				node1.beconnect=true;
				node1.dbeconnect=true;
				node1.dbeconnectx=node.x;
				node1.dbeconnecty=node.y;
				node1.dbeconnectID=node.ID;
				node1.dbeconnetName=new String(node.name);
				return;
			}	
			while(node1.next!=null){
				node1=node1.next;
				x=arg0.getX();
				y=arg0.getY();
				if((x>node1.x-20)&&(x<node1.x+50)&&(y>node1.y)&&(y<node1.y+16)&&(node.ID!=node1.ID)){
					node1.beconnect=true;
					node1.tbeconnect=true;
					node1.tbeconnectx=node.x;
					node1.tbeconnecty=node.y;
					node1.tbeconnectID=node.ID;
					node1.tbeconnetName=new String(node.name);
					return;
				}
				if((x>node1.x-20)&&(x<node1.x+50)&&(y>node1.y+16)&&(y<node1.y+32)&&(node.ID!=node1.ID)){
					node1.beconnect=true;
					node1.mbeconnect=true;
					node1.mbeconnectx=node.x;
					node1.mbeconnecty=node.y;
					node1.mbeconnectID=node.ID;
					node1.mbeconnetName=new String(node.name);
					return;
				}	
				if((x>node1.x-20)&&(x<node1.x+50)&&(y>node1.y+32)&&(y<node1.y+50)&&(node.ID!=node1.ID)){
					node1.beconnect=true;
					node1.dbeconnect=true;
					node1.dbeconnectx=node.x;
					node1.dbeconnecty=node.y;
					node1.dbeconnectID=node.ID;
					node1.dbeconnetName=new String(node.name);
					return;
				}
			}
		}
	}
}