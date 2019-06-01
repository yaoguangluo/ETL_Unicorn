package org.LYG.GUI.nodeEdit;
public class DynamicLineUpdater{
	public void exec(LinkNode first,LinkNode node){
		LinkNode linkNode = first;
		while(null != linkNode) {
			if(linkNode.ID==node.tBeconnectID){
				node.tBeconnectX=linkNode.x;
				node.tBeconnectY=linkNode.y;
			}
			if(linkNode.tBeconnectID==node.ID) {
				linkNode.tBeconnectX=node.x;
				linkNode.tBeconnectY=node.y;
			}
			if(linkNode.ID==node.mBeconnectID){
				node.mBeconnectX=linkNode.x;
				node.mBeconnectY=linkNode.y;
			}
			if(linkNode.mBeconnectID==node.ID) {
				linkNode.mBeconnectX=node.x;
				linkNode.mBeconnectY=node.y;
			}

			if(linkNode.ID==node.dBeconnectID) {
				node.dBeconnectX=linkNode.x;
				node.dBeconnectY=linkNode.y;
			}
			if(linkNode.dBeconnectID==node.ID) {
				linkNode.dBeconnectX=node.x;
				linkNode.dBeconnectY=node.y;
			}
			linkNode=linkNode.next; 
		}
		linkNode = null;
	}
	public DynamicLineUpdater() {
	}
}