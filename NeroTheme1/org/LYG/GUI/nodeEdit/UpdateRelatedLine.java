package org.LYG.GUI.nodeEdit;
public class UpdateRelatedLine{
	public UpdateRelatedLine(LinkNode first, String currentNodeName, int currentNodeID){
		first = new Sort().sort(first);
		if(null != first){
			if(first.tbeconnect&&first.tbeconnetName.equals(currentNodeName)&&first.tbeconnectID==currentNodeID){
				first.tbeconnect=false;
			}
			if(first.mbeconnect&&first.mbeconnetName.equals(currentNodeName)&&first.mbeconnectID==currentNodeID){
				first.mbeconnect=false;
			}
			if(first.dbeconnect&&first.dbeconnetName.equals(currentNodeName)&&first.dbeconnectID==currentNodeID){
				first.dbeconnect=false;
			}
			while(null != first.next){
				first=first.next;
				if(first.tbeconnect&&first.tbeconnetName.equals(currentNodeName)&&first.tbeconnectID==currentNodeID){
					first.tbeconnect=false;
				}
				if(first.mbeconnect&&first.mbeconnetName.equals(currentNodeName)&&first.mbeconnectID==currentNodeID){
					first.mbeconnect=false;
				}
				if(first.dbeconnect&&first.dbeconnetName.equals(currentNodeName)&&first.dbeconnectID==currentNodeID){
					first.dbeconnect=false;
				}
			}
		}
	}
}