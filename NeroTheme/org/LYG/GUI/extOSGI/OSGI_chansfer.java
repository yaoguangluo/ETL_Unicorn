package org.LYG.GUI.extOSGI;
import org.LYG.GUI.nodeEdit.Sort;
import org.LYG.GUI.nodeEdit.LinkNode;
public class OSGI_chansfer {
	public OSGI_chansfer(LinkNode node, LinkNode first){
		first= Sort.sort(first);
		LinkNode linkNode= new LinkNode();
		linkNode= first;
		while(null!= linkNode){
			if(node.tBeconnect&&node.tBeconnectID== linkNode.ID&&node.tBeconnetName.equals(linkNode.name)
					&& (node.tBeconnectPrimaryKey.equalsIgnoreCase(linkNode.primaryKey))){
				node.thisFace.thisRun.toptablein = linkNode.thisFace.thisView.tableout;
				node.thisFace.thisRun.topgin = linkNode.thisFace.thisView.gout;
				return;
			}
			if(node.mBeconnect&&node.mBeconnectID== linkNode.ID&&node.mBeconnetName.equals(linkNode.name)
					&& (node.mBeconnectPrimaryKey.equalsIgnoreCase(linkNode.primaryKey))){
				node.thisFace.thisRun.midtablein = linkNode.thisFace.thisView.tableout;
				node.thisFace.thisRun.midgin = linkNode.thisFace.thisView.gout;
				return;
			}	
			if(node.dBeconnect&&node.dBeconnectID== linkNode.ID&&node.dBeconnetName.equals(linkNode.name)
					&& (node.dBeconnectPrimaryKey.equalsIgnoreCase(linkNode.primaryKey))){
				node.thisFace.thisRun.downtablein = linkNode.thisFace.thisView.tableout;
				node.thisFace.thisRun.downgin = linkNode.thisFace.thisView.gout;
				return;
			}	
			if(null!= linkNode.next){
				break;
			}
			linkNode=linkNode.next;
		}
	}
}
