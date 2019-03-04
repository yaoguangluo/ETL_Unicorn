package org.LYG.GUI.nodeEdit;
import java.awt.event.MouseEvent;
public class CheckRange{
	public CheckRange(LinkNode first,LinkNode node, MouseEvent arg0) {
		LinkNode linkNode=first;
		int x,y;
		x=arg0.getX();
		y=arg0.getY();
		while(null != linkNode){
			if((x>linkNode.x-20)&&(x<linkNode.x+100)&&(y>linkNode.y-100)&&(y<linkNode.y+16)&&(node.ID!=linkNode.ID)){
				linkNode.beconnect=true;
				linkNode.tbeconnect=true;
				linkNode.tbeconnectx=node.x;
				linkNode.tbeconnecty=node.y;
				linkNode.tbeconnectID=node.ID;
				linkNode.tbeconnetName=new String(node.name);
				return;
			}
			if((x>linkNode.x-20)&&(x<linkNode.x+50)&&(y>linkNode.y+16)&&(y<linkNode.y+32)&&(node.ID!=linkNode.ID)){
				linkNode.beconnect=true;
				linkNode.mbeconnect=true;
				linkNode.mbeconnectx=node.x;
				linkNode.mbeconnecty=node.y;
				linkNode.mbeconnectID=node.ID;
				linkNode.mbeconnetName=new String(node.name);
				return;
			}	
			if((x>linkNode.x-20)&&(x<linkNode.x+50)&&(y>linkNode.y+32)&&(y<linkNode.y+100)&&(node.ID!=linkNode.ID)){
				linkNode.beconnect=true;
				linkNode.dbeconnect=true;
				linkNode.dbeconnectx=node.x;
				linkNode.dbeconnecty=node.y;
				linkNode.dbeconnectID=node.ID;
				linkNode.dbeconnetName=new String(node.name);
				return;
			}	
			linkNode=linkNode.next;
		}
	}
}