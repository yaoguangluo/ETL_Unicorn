package org.LYG.GUI.nodeEdit;
public class DynamicLineUpdater{
	public void exec(LinkNode first,LinkNode node){
		LinkNode linkNode = first;
		if(null != linkNode) {
			if(linkNode.ID==node.tbeconnectID){
				node.tbeconnectx=linkNode.x;
				node.tbeconnecty=linkNode.y;
			}
			if(linkNode.tbeconnectID==node.ID) {
				linkNode.tbeconnectx=node.x;
				linkNode.tbeconnecty=node.y;
			}
			if(linkNode.ID==node.mbeconnectID){
				node.mbeconnectx=linkNode.x;
				node.mbeconnecty=linkNode.y;
			}
			if(linkNode.mbeconnectID==node.ID) {
				linkNode.mbeconnectx=node.x;
				linkNode.mbeconnecty=node.y;
			}

			if(linkNode.ID==node.dbeconnectID) {
				node.dbeconnectx=linkNode.x;
				node.dbeconnecty=linkNode.y;
			}
			if(linkNode.dbeconnectID==node.ID) {
				linkNode.dbeconnectx=node.x;
				linkNode.dbeconnecty=node.y;
			}
			while(null != linkNode.next) {
				linkNode=linkNode.next;
				if(linkNode.ID==node.tbeconnectID) {
					node.tbeconnectx=linkNode.x;
					node.tbeconnecty=linkNode.y;
				}
				if(linkNode.tbeconnectID==node.ID){
					linkNode.tbeconnectx=node.x;
					linkNode.tbeconnecty=node.y;
				}

				if(linkNode.ID==node.mbeconnectID){
					node.mbeconnectx=linkNode.x;
					node.mbeconnecty=linkNode.y;
				}
				if(linkNode.mbeconnectID==node.ID){
					linkNode.mbeconnectx=node.x;
					linkNode.mbeconnecty=node.y;
				}

				if(linkNode.ID==node.dbeconnectID) {
					node.dbeconnectx=linkNode.x;
					node.dbeconnecty=linkNode.y;
				}
				if(linkNode.dbeconnectID==node.ID) {
					linkNode.dbeconnectx=node.x;
					linkNode.dbeconnecty=node.y;
				}   
			} 
		}
		linkNode = null;
	}
	public DynamicLineUpdater() {
	}
}