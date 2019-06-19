package org.LYG.GUI.nodeEdit;
import org.LYG.GUI.nodeEdit.controller.DynamicLineUpdater;
public class DynamicLineUpdaterVPS implements DynamicLineUpdater{
	public void exec(LinkNode first,LinkNode node){
		LinkNode linkNode= first;
		while(null!= linkNode) {
			if(linkNode.primaryKey.equalsIgnoreCase(node.tBeconnectPrimaryKey)){
				node.tBeconnectX= linkNode.x;
				node.tBeconnectY= linkNode.y;
			}
			if(linkNode.tBeconnectPrimaryKey.equalsIgnoreCase(node.primaryKey)){
				linkNode.tBeconnectX= node.x;
				linkNode.tBeconnectY= node.y;
			}
			if(linkNode.primaryKey.equalsIgnoreCase(node.mBeconnectPrimaryKey)){
				node.mBeconnectX= linkNode.x;
				node.mBeconnectY= linkNode.y;
			}
			if(linkNode.mBeconnectPrimaryKey.equalsIgnoreCase(node.primaryKey)){
				linkNode.mBeconnectX= node.x;
				linkNode.mBeconnectY= node.y;
			}
			if(linkNode.primaryKey.equalsIgnoreCase(node.dBeconnectPrimaryKey)){
				node.dBeconnectX= linkNode.x;
				node.dBeconnectY= linkNode.y;
			}
			if(linkNode.dBeconnectPrimaryKey.equalsIgnoreCase(node.primaryKey)){
				linkNode.dBeconnectX= node.x;
				linkNode.dBeconnectY= node.y;
			}
			linkNode= linkNode.next; 
		}
		linkNode= null;
	}
}