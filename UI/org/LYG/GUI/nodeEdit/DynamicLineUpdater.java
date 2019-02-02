package org.LYG.GUI.nodeEdit;
public class DynamicLineUpdater{
	public void exec(LinkNode first,LinkNode node){
		LinkNode node1=new LinkNode();
		first=new Sort().sort(first);
		node1=first;
		if(node1!=null) {
			if(node1.ID==node.tbeconnectID){
				node.tbeconnectx=node1.x;
				node.tbeconnecty=node1.y;
			}
			if(node1.tbeconnectID==node.ID) {
				node1.tbeconnectx=node.x;
				node1.tbeconnecty=node.y;
			}

			if(node1.ID==node.mbeconnectID){
				node.mbeconnectx=node1.x;
				node.mbeconnecty=node1.y;
			}
			if(node1.mbeconnectID==node.ID) {
				node1.mbeconnectx=node.x;
				node1.mbeconnecty=node.y;
			}

			if(node1.ID==node.dbeconnectID) {
				node.dbeconnectx=node1.x;
				node.dbeconnecty=node1.y;
			}
			if(node1.dbeconnectID==node.ID) {
				node1.dbeconnectx=node.x;
				node1.dbeconnecty=node.y;
			}


			while(node1.next!=null) {
				node1=node1.next;
				if(node1.ID==node.tbeconnectID) {
					node.tbeconnectx=node1.x;
					node.tbeconnecty=node1.y;
				}
				if(node1.tbeconnectID==node.ID){
					node1.tbeconnectx=node.x;
					node1.tbeconnecty=node.y;
				}

				if(node1.ID==node.mbeconnectID){
					node.mbeconnectx=node1.x;
					node.mbeconnecty=node1.y;
				}
				if(node1.mbeconnectID==node.ID){
					node1.mbeconnectx=node.x;
					node1.mbeconnecty=node.y;
				}

				if(node1.ID==node.dbeconnectID) {
					node.dbeconnectx=node1.x;
					node.dbeconnecty=node1.y;
				}
				if(node1.dbeconnectID==node.ID) {
					node1.dbeconnectx=node.x;
					node1.dbeconnecty=node.y;
				}   
			} 
		}
		node1=null;
	}
	public DynamicLineUpdater() {
		// TODO Auto-generated constructor stub
	}
}