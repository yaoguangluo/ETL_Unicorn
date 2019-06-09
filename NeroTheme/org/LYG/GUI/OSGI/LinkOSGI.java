package org.LYG.GUI.OSGI;
public class LinkOSGI{
	public NodeOSGI addNode(NodeOSGI currentNode, ObjectInterface currentFace) {
		if(null== currentNode){
			currentNode= new NodeOSGI();
			currentNode.addName(currentFace);
			currentNode.next= null;
			currentNode.pre= null;
			return currentNode;
		}
		while(currentNode.next!= null){
			currentNode= currentNode.next;
		}
		NodeOSGI node= new NodeOSGI();
		node.addName(currentFace);
		node.pre= currentNode;
		currentNode.next= node;
		while(currentNode.pre!= null){
			currentNode= currentNode.pre;
		}
		return currentNode;
	} 
}