package org.LYG.GUI.OSGI;
public class LinkOSGI{
	public NodeOSGI addNode(NodeOSGI currentnode, ObjectInterface currentface) {
		if(currentnode == null){
			currentnode = new NodeOSGI();
			currentnode.addName(currentface);
			currentnode.next = null;
			currentnode.pre = null;
			return currentnode;
		}
		while(currentnode.next != null){
			currentnode = currentnode.next;
		}
		NodeOSGI node = new NodeOSGI();
		node.addName(currentface);
		node.pre = currentnode;
		currentnode.next = node;
		while(currentnode.pre != null){
			currentnode = currentnode.pre;
		}
		return currentnode;
	} 
}