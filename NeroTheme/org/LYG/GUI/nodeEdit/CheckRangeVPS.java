package org.LYG.GUI.nodeEdit;
import java.awt.event.MouseEvent;
import org.LYG.GUI.nodeEdit.controller.CheckRange;
public class CheckRangeVPS implements CheckRange{
	public void doCheckRange(LinkNode first, LinkNode node, MouseEvent arg0) {
		LinkNode linkNode= first;
		int x, y;
		x= arg0.getX();
		y= arg0.getY();
		while(null!= linkNode){
			if((x> linkNode.x- 20)&& (x< linkNode.x+ 100)&& (y> linkNode.y- 100)&& (y< linkNode.y+ 16)
					&& (!node.primaryKey.equalsIgnoreCase(linkNode.primaryKey))){
				linkNode.beconnect= true;
				linkNode.tBeconnect= true;
				linkNode.tBeconnectX= node.x;
				linkNode.tBeconnectY= node.y;
				linkNode.tBeconnectID= node.ID;
				linkNode.tBeconnectPrimaryKey= node.primaryKey;
				linkNode.tBeconnetName= new String(node.name);
				return;
			}
			if((x> linkNode.x- 20)&& (x< linkNode.x+ 50)&& (y> linkNode.y+ 16)&& (y< linkNode.y+ 32)
					&& (!node.primaryKey.equalsIgnoreCase(linkNode.primaryKey))){
				linkNode.beconnect= true;
				linkNode.mBeconnect= true;
				linkNode.mBeconnectX= node.x;
				linkNode.mBeconnectY= node.y;
				linkNode.mBeconnectID= node.ID;
				linkNode.mBeconnectPrimaryKey= node.primaryKey;
				linkNode.mBeconnetName= new String(node.name);
				return;
			}	
			if((x> linkNode.x- 20)&& (x< linkNode.x+ 50)&& (y> linkNode.y+ 32)&& (y< linkNode.y+ 100)
					&& (!node.primaryKey.equalsIgnoreCase(linkNode.primaryKey))){
				linkNode.beconnect= true;
				linkNode.dBeconnect= true;
				linkNode.dBeconnectX= node.x;
				linkNode.dBeconnectY= node.y;
				linkNode.dBeconnectID= node.ID;
				linkNode.dBeconnectPrimaryKey= node.primaryKey;
				linkNode.dBeconnetName= new String(node.name);
				return;
			}	
			linkNode= linkNode.next;
		}
	}
}