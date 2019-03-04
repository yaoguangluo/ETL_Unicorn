package org.LYG.GUI.nodeEdit;
import java.awt.event.MouseEvent;
public class ChooseCheck{
	public ChooseCheck() 
	{}

	public LinkNode chooseCheckNode(LinkNode first, MouseEvent arg0) {
		first = new Sort().sort(first);
		LinkNode node = first;
		int x,y;
		x = arg0.getX();
		y = arg0.getY();
		if(null != node){
			if((x > node.x) && (x < node.x + 50) && (y > node.y) && (y < node.y + 50)){
				if(arg0.getButton() == 1){
					node.leftchoose=true;
				}
				if(arg0.getButton() == 3){
					node.rightchoose = true;
				}
				return node;	
			}
			while(null != node.next){
				x = arg0.getX();
				y = arg0.getY();
				node = node.next;
				if((x > node.x) && (x < node.x + 50) && (y>node.y) && (y < node.y + 50)){
					if(arg0.getButton() == 1){
						node.leftchoose = true;
					}
					if(arg0.getButton() == 3){
						node.rightchoose = true;
					}
					return node;
				}	
			}
		}
		LinkNode emptyNode =new LinkNode();
		emptyNode.name = "";
		emptyNode.ID = 0;
		return emptyNode;
	}	
}