package org.LYG.GUI.nodeEdit;
import java.awt.event.MouseEvent;
public class ChooseCheck{
	public ChooseCheck() 
	{}
	public int chooseCheckid(LinkNode first, MouseEvent arg0) {
		LinkNode node=new LinkNode();
		first=new Sort().sort(first);;
		node=first;
		int x,y;
		x = arg0.getX();
		y = arg0.getY();
		if(node != null){
			//x -= node.x;
			//y -= node.y;
			//x=Math.abs(x);
			//y=Math.abs(y);
			if((x > node.x) && (x < node.x + 50) && (y > node.y) && (y < node.y + 50)){
				if(arg0.getButton() == 1){
				  node.leftchoose = true;
				}
				if(arg0.getButton() == 3){
					node.rightchoose = true;
				}
				return node.ID;	
			}
			while(node.next != null){
				x = arg0.getX();
				y = arg0.getY();
				node = node.next;
				if((x > node.x) && (x < node.x + 50) && (y > node.y) && (y < node.y + 50)){
					if(arg0.getButton()==1){
					    node.leftchoose=true;
					}
					if(arg0.getButton()==3){
						node.rightchoose=true;
					}
					return node.ID;
				}	
			}
		}
		return 0;
	}
	public String chooseCheckname(LinkNode first,MouseEvent arg0) {
		LinkNode node = new LinkNode();
		first = new Sort().sort(first);
		node = first;
		int x,y;
		x = arg0.getX();
		y = arg0.getY();
		if(node != null){
			if((x > node.x) && (x < node.x + 50) && (y > node.y) && (y < node.y + 50)){
				if(arg0.getButton() == 1){
				  node.leftchoose=true;
				}
				if(arg0.getButton() == 3){
					node.rightchoose = true;
				}
				return node.name;	
			}
			while(node.next != null){
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
					return node.name;
				}	
			}
		}
		return "";
	}	
}