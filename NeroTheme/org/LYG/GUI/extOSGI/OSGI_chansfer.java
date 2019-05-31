package org.LYG.GUI.extOSGI;
import org.LYG.GUI.nodeEdit.Sort;
import org.LYG.GUI.nodeEdit.LinkNode;
public class OSGI_chansfer {
	public OSGI_chansfer(LinkNode node, LinkNode first){
		first = new Sort().sort(first);
		LinkNode linkNode = new LinkNode();
		linkNode = first;
		if(null != linkNode){
			if(node.tbeconnect&&node.tbeconnectID == linkNode.ID&&node.tbeconnetName.equals(linkNode.name)){
				node.thisface.thisRun.toptablein = linkNode.thisface.thisView.tableout;
				node.thisface.thisRun.topgin = linkNode.thisface.thisView.gout;
				return;
			}
			if(node.mbeconnect&&node.mbeconnectID == linkNode.ID&&node.mbeconnetName.equals(linkNode.name)){
				node.thisface.thisRun.midtablein = linkNode.thisface.thisView.tableout;
				node.thisface.thisRun.midgin = linkNode.thisface.thisView.gout;
				return;
			}	
			if(node.dbeconnect&&node.dbeconnectID == linkNode.ID&&node.dbeconnetName.equals(linkNode.name)){
				node.thisface.thisRun.downtablein = linkNode.thisface.thisView.tableout;
				node.thisface.thisRun.downgin = linkNode.thisface.thisView.gout;
				return;
			}	
			while(null != linkNode.next){
				linkNode=linkNode.next;
				if(node.tbeconnect&&node.tbeconnectID == linkNode.ID&&node.tbeconnetName.equals(linkNode.name)){
					node.thisface.thisRun.toptablein = linkNode.thisface.thisView.tableout;
					node.thisface.thisRun.topgin = linkNode.thisface.thisView.gout;
					return;
				}
				if(node.mbeconnect&&node.mbeconnectID == linkNode.ID&&node.mbeconnetName.equals(linkNode.name)){
					node.thisface.thisRun.midtablein = linkNode.thisface.thisView.tableout;
					node.thisface.thisRun.midgin = linkNode.thisface.thisView.gout;
					return;
				}	
				if(node.dbeconnect&&node.dbeconnectID == linkNode.ID&&node.dbeconnetName.equals(linkNode.name)){
					node.thisface.thisRun.downtablein = linkNode.thisface.thisView.tableout;
					node.thisface.thisRun.downgin = linkNode.thisface.thisView.gout;
					return;
				}
			}
		}
	}
}
