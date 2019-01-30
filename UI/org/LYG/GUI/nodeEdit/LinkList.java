package org.LYG.GUI.nodeEdit;
import java.io.IOException;

import org.LYG.GUI.OSGI.*;
public class LinkList{
	int index=0;
	String key;
	linkNode first;
	public int sum_of_nude=0;
	public LinkList(){}
	public boolean search(linkNode first2,String key){
		if(first2==null){
			return false;
		}
		if(first2.name.equals(key)){
			return true;
		}
		while(first2.next!=null){
			first2=first2.next;
			if(first2.name.equals(key)){
				while(first2.pre!=null){
					first2=first2.pre;
				}
				return true;
			}
		}
		return false;
	}
	public linkNode addNode(linkNode first2, String treeNodeName,int x,int y,nodeOSGI nOSGI ) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IOException {
		nodeOSGI currentOSGI=nOSGI;
		while(currentOSGI!=null&&currentOSGI.pre!=null){
			currentOSGI=currentOSGI.pre;
		}
		if(first2==null){			
			if(currentOSGI!=null){
				if(currentOSGI.thisname.equals(treeNodeName)){
					first2=new linkNode();
					first2.addName(treeNodeName,x,y,++index);
					first2.thisface=currentOSGI.currentFace.luoyaoguang();
					first2.next=null;
					first2.pre=null;
					sum_of_nude++;
					return first2;
				}
				while(currentOSGI.next!=null){
					currentOSGI=currentOSGI.next;
					if(currentOSGI.thisname.equals(treeNodeName)){
						first2=new linkNode();
						first2.addName(treeNodeName,x,y,++index);
						first2.thisface=currentOSGI.currentFace.luoyaoguang();
						first2.next=null;
						first2.pre=null;
						sum_of_nude++;
						return first2;
					}
				}
			}

		}
		while(first2.next != null){
			first2 = first2.next;
		}

		if(currentOSGI!=null){
			if(currentOSGI.thisname.equals(treeNodeName)){
				//first2=new linkNode();
				linkNode node = new linkNode();
				node.addName(treeNodeName,x,y,++index);
				node.thisface=currentOSGI.currentFace.luoyaoguang();
				node.pre=first2;
				first2.next=node;
				sum_of_nude++;
				return first2;
			}
			while(currentOSGI.next!=null){
				currentOSGI=currentOSGI.next;
				if(currentOSGI.thisname.equals(treeNodeName)){
					linkNode node = new linkNode();
					node.addName(treeNodeName,x,y,++index);
					node.thisface=currentOSGI.currentFace.luoyaoguang();
					node.pre=first2;
					first2.next=node;
					sum_of_nude++;
					return first2;
				}
			}
		}
		while(first2.pre != null){
			first2 = first2.pre;
		}
		sum_of_nude++;
		return first2;
	} 
	public linkNode deletNode(linkNode first2, String name,int ID){
		if(first2!=null){
			if(first2.name.equals(name)&&first2.ID==ID){
				if(first2.next!=null){
					first2=first2.next;
					first2.pre=null;
					return first2;	
				}
				if(first2.next==null){
					first2=null;
					return first2;	
				}
			}
			while(first2.next!=null){
				first2 = first2.next;
				if(first2.name.equals(name)&&first2.ID==ID){
					if(first2.next!=null){
						@SuppressWarnings("unused")
						linkNode node =first2;
						first2=first2.next;
						first2.pre=first2.pre.pre;
						first2.pre.next=first2;
						node=null;
						first2=new Sort().sort(first2);
						return first2;		
					}
					if(first2.next==null){
						first2=first2.pre;
						first2.next=null;
						first2=new Sort().sort(first2);
						return first2;				
					}
				}
			}
		}
		return first2;	
	}
	public void print(linkNode first2) {
		System.out.println(first2.name);
		while(first2.next!=null){
			first2 = first2.next;
			System.out.println(first2.name);
		}
	}
}