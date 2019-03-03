package org.LYG.GUI.nodeEdit;
import java.io.IOException;

import org.LYG.GUI.OSGI.*;
public class LinkList{
	int index=0;
	String key;
	LinkNode first;
	public int sum_of_nude=0;
	public LinkList(){}
	public boolean search(LinkNode linkNode,String key){
		if(linkNode==null){
			return false;
		}
		if(linkNode.name.equals(key)){
			return true;
		}
		while(linkNode.next!=null){
			linkNode=linkNode.next;
			if(linkNode.name.equals(key)){
				while(linkNode.pre!=null){
					linkNode=linkNode.pre;
				}
				return true;
			}
		}
		return false;
	}
	public LinkNode addNode(LinkNode linkNode, String treeNodeName,int x,int y,nodeOSGI nOSGI ) 
			throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IOException {
		nodeOSGI currentOSGI=nOSGI;
		while(currentOSGI!=null&&currentOSGI.pre!=null){
			currentOSGI=currentOSGI.pre;
		}
		if(linkNode==null){			
			if(currentOSGI!=null){
				if(currentOSGI.thisname.equals(treeNodeName)){
					linkNode=new LinkNode();
					linkNode.addName(treeNodeName,x,y,++index);
					linkNode.thisface=currentOSGI.currentFace.luoyaoguang();
					linkNode.next=null;
					linkNode.pre=null;
					sum_of_nude++;
					return linkNode;
				}
				while(currentOSGI.next!=null){
					currentOSGI=currentOSGI.next;
					if(currentOSGI.thisname.equals(treeNodeName)){
						linkNode=new LinkNode();
						linkNode.addName(treeNodeName,x,y,++index);
						linkNode.thisface=currentOSGI.currentFace.luoyaoguang();
						linkNode.next=null;
						linkNode.pre=null;
						sum_of_nude++;
						return linkNode;
					}
				}
			}

		}
		while(linkNode.next != null){
			linkNode = linkNode.next;
		}

		if(currentOSGI!=null){
			if(currentOSGI.thisname.equals(treeNodeName)){
				//linkNode=new linkNode();
				LinkNode node = new LinkNode();
				node.addName(treeNodeName, x, y, ++index);
				node.thisface = currentOSGI.currentFace.luoyaoguang();
				node.pre = linkNode;
				linkNode.next = node;
				sum_of_nude ++;
				return linkNode;
			}
			while(currentOSGI.next != null){
				currentOSGI = currentOSGI.next;
				if(currentOSGI.thisname.equals(treeNodeName)){
					LinkNode node = new LinkNode();
					node.addName(treeNodeName,x,y,++index);
					node.thisface = currentOSGI.currentFace.luoyaoguang();
					node.pre = linkNode;
					linkNode.next = node;
					sum_of_nude ++;
					return linkNode;
				}
			}
		}
		while(linkNode.pre != null){
			linkNode = linkNode.pre;
		}
		sum_of_nude++;
		return linkNode;
	} 
	public LinkNode deletNode(LinkNode linkNode, String name,int ID){
		if(linkNode!=null){
			if(linkNode.name.equals(name)&&linkNode.ID==ID){
				if(linkNode.next!=null){
					linkNode=linkNode.next;
					linkNode.pre=null;
					return linkNode;	
				}
				if(linkNode.next==null){
					linkNode=null;
					return linkNode;	
				}
			}
			while(linkNode.next!=null){
				linkNode = linkNode.next;
				if(linkNode.name.equals(name)&&linkNode.ID==ID){
					if(linkNode.next!=null){
						@SuppressWarnings("unused")
						LinkNode node =linkNode;
						linkNode=linkNode.next;
						linkNode.pre=linkNode.pre.pre;
						linkNode.pre.next=linkNode;
						node=null;
						linkNode=new Sort().sort(linkNode);
						return linkNode;		
					}
					if(linkNode.next==null){
						linkNode=linkNode.pre;
						linkNode.next=null;
						linkNode=new Sort().sort(linkNode);
						return linkNode;				
					}
				}
			}
		}
		return linkNode;	
	}
}