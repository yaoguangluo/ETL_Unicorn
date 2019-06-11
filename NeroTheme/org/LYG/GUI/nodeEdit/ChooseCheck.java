package org.LYG.GUI.nodeEdit;
import java.awt.event.MouseEvent;
public class ChooseCheck{
	public ChooseCheck() 
	{}

	public LinkNode chooseCheckNode(LinkNode first, MouseEvent arg0) {
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
				return node;	
			}
			if(null== node.next) {
				break;
			}
			node= node.next;
		}
		LinkNode emptyNode= new LinkNode();
		emptyNode.name= "";
		emptyNode.ID= 0;
		return emptyNode;
	}	
}