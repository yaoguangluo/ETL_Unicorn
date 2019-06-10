package org.LYG.GUI.nodeEdit;
public class UpdateRelatedLine{
	public UpdateRelatedLine(LinkNode first, String currentNodeName
			, int currentNodeID, String currentNodePrimaryKey){
		first = new Sort().sort(first);
		while(null!= first) {
			if(first.tBeconnect&& first.tBeconnetName.equals(currentNodeName)
					&& first.tBeconnectID== currentNodeID
					&& first.tBeconnectPrimaryKey.equalsIgnoreCase(currentNodePrimaryKey)){
				first.tBeconnect= false;
			}
			if(first.mBeconnect&& first.mBeconnetName.equals(currentNodeName)
					&& first.mBeconnectID== currentNodeID
					&& first.mBeconnectPrimaryKey.equalsIgnoreCase(currentNodePrimaryKey)){
				first.mBeconnect= false;
			}
			if(first.dBeconnect&& first.dBeconnetName.equals(currentNodeName)
					&& first.dBeconnectID== currentNodeID
					&& first.dBeconnectPrimaryKey.equalsIgnoreCase(currentNodePrimaryKey)){
				first.dBeconnect= false;
			}
			if(null== first.next) {
				break;
			}
			first= first.next;
		}
	}
}