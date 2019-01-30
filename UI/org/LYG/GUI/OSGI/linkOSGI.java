package org.LYG.GUI.OSGI;
public class linkOSGI{
	public nodeOSGI addNode(nodeOSGI currentnode, objectInterface currentface) {
		if(currentnode==null){
			currentnode=new nodeOSGI();
			currentnode.addName(currentface);
			currentnode.next=null;
			currentnode.pre=null;
			return currentnode;
		}
		while(currentnode.next != null){
			currentnode = currentnode.next;
		}
		nodeOSGI node = new nodeOSGI();
		node.addName(currentface);
		node.pre=currentnode;
		currentnode.next=node;
		while(currentnode.pre != null){
			currentnode = currentnode.pre;
		}
		return currentnode;
	} 
}