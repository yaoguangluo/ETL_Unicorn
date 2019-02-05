package org.LYG.GUI.extOSGI;
import org.LYG.GUI.nodeEdit.Sort;
import org.LYG.GUI.nodeEdit.LinkNode;
public class OSGI_chansfer {
	public OSGI_chansfer(LinkNode node, LinkNode first){
		first = new Sort().sort(first);
		LinkNode node1 = new LinkNode();
	    node1 = first;
	    if(null != node1){
			if(node.tbeconnect&&node.tbeconnectID == node1.ID&&node.tbeconnetName.equals(node1.name)){
                node.thisface.thisrun.toptablein = node1.thisface.thisview.tableout;
                node.thisface.thisrun.topgin = node1.thisface.thisview.gout;
				return;
			}
			if(node.mbeconnect&&node.mbeconnectID == node1.ID&&node.mbeconnetName.equals(node1.name)){
                node.thisface.thisrun.midtablein = node1.thisface.thisview.tableout;
                node.thisface.thisrun.midgin = node1.thisface.thisview.gout;
				return;
			}	
			if(node.dbeconnect&&node.dbeconnectID == node1.ID&&node.dbeconnetName.equals(node1.name)){
                node.thisface.thisrun.downtablein = node1.thisface.thisview.tableout;
                node.thisface.thisrun.downgin = node1.thisface.thisview.gout;
				return;
			}	
			while(null != node1.next){
				node1=node1.next;
				if(node.tbeconnect&&node.tbeconnectID == node1.ID&&node.tbeconnetName.equals(node1.name)){
	                node.thisface.thisrun.toptablein = node1.thisface.thisview.tableout;
	                node.thisface.thisrun.topgin = node1.thisface.thisview.gout;
					return;
				}
				if(node.mbeconnect&&node.mbeconnectID == node1.ID&&node.mbeconnetName.equals(node1.name)){
	                node.thisface.thisrun.midtablein = node1.thisface.thisview.tableout;
	                node.thisface.thisrun.midgin = node1.thisface.thisview.gout;
					return;
				}	
				if(node.dbeconnect&&node.dbeconnectID == node1.ID&&node.dbeconnetName.equals(node1.name)){
	                node.thisface.thisrun.downtablein = node1.thisface.thisview.tableout;
	                node.thisface.thisrun.downgin = node1.thisface.thisview.gout;
					return;
				}
			}
	    }
	}
}
