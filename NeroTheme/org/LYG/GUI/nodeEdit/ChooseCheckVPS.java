package org.LYG.GUI.nodeEdit;
import java.awt.event.MouseEvent;
import org.LYG.GUI.nodeEdit.controller.ChooseCheck;;
public class ChooseCheckVPS implements ChooseCheck {
	public Object[] chooseCheckNode(LinkNode first, MouseEvent arg0) {
		LinkNode node= first;
		int x, y;
		while(null!= node){
			x= arg0.getX();
			y= arg0.getY();
			if((x> node.x)&& (x< node.x+ 50)&& (y> node.y)&& (y< node.y+ 50)){
				if(1== arg0.getButton()){
					node.leftChoose= true;
				}
				if(3== arg0.getButton()){
					node.rightChoose= true;
				}
				Object[] object= new Object[3];
				object[0]= node.name;
				object[1]= node.ID;
				object[2]= node.primaryKey;
				return object;	
			}
			if(null== node.next) {
				break;
			}
			node= node.next;
		}
		Object[] object= new Object[3];
		object[0]= "";
		object[1]= 0;
		object[2]= "";
		return object;	
	}	
}