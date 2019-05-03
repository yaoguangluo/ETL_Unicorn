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
				node.thisface.thisrun.toptablein = linkNode.thisface.thisview.tableout;
				node.thisface.thisrun.topgin = linkNode.thisface.thisview.gout;
				return;
			}
			if(node.mbeconnect&&node.mbeconnectID == linkNode.ID&&node.mbeconnetName.equals(linkNode.name)){
				node.thisface.thisrun.midtablein = linkNode.thisface.thisview.tableout;
				node.thisface.thisrun.midgin = linkNode.thisface.thisview.gout;
				return;
			}	
			if(node.dbeconnect&&node.dbeconnectID == linkNode.ID&&node.dbeconnetName.equals(linkNode.name)){
				node.thisface.thisrun.downtablein = linkNode.thisface.thisview.tableout;
				node.thisface.thisrun.downgin = linkNode.thisface.thisview.gout;
				return;
			}	
			while(null != linkNode.next){
				linkNode=linkNode.next;
				if(node.tbeconnect&&node.tbeconnectID == linkNode.ID&&node.tbeconnetName.equals(linkNode.name)){
					node.thisface.thisrun.toptablein = linkNode.thisface.thisview.tableout;
					node.thisface.thisrun.topgin = linkNode.thisface.thisview.gout;
					return;
				}
				if(node.mbeconnect&&node.mbeconnectID == linkNode.ID&&node.mbeconnetName.equals(linkNode.name)){
					node.thisface.thisrun.midtablein = linkNode.thisface.thisview.tableout;
					node.thisface.thisrun.midgin = linkNode.thisface.thisview.gout;
					return;
				}	
				if(node.dbeconnect&&node.dbeconnectID == linkNode.ID&&node.dbeconnetName.equals(linkNode.name)){
					node.thisface.thisrun.downtablein = linkNode.thisface.thisview.tableout;
					node.thisface.thisrun.downgin = linkNode.thisface.thisview.gout;
					return;
				}
			}
		}
	}
}
