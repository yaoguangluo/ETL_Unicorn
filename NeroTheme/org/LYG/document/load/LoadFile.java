package org.LYG.document.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeEdit.LinkNode;
import org.LYG.GUI.nodeEdit.Sort;
import org.LYG.GUI.nodeView.NodeShow;
//准备把响应事件移植到这里。
import org.LYG.sets.stable.StableData;
public class LoadFile{
	@SuppressWarnings({StableData.TAG_RESOURCE})
	public static LinkNode Load(LinkNode first, NodeShow nodeView, File file, LinkList thislist) {
		//get path
		try {
			InputStream in= new FileInputStream(file);
			BufferedReader cReader= new BufferedReader(new InputStreamReader(in));  
			String ctempString= null; 
			Map<String, String> currentNodeMap= new HashMap<>();
			while ((ctempString= cReader.readLine())!= null) {  
				if(!ctempString.contains("######################")) {
					if(ctempString.contains(":")&& ctempString.split(":").length>1) {
						currentNodeMap.put(ctempString.split(":")[0], ctempString.split(":")[1]);
					}
				}else {
					LinkNode node= new LinkNode();
					node.beconnect= currentNodeMap.containsKey("beconnect")? currentNodeMap.get("beconnect").contains("false")? false: true: false;
					node.dBeconnect= currentNodeMap.containsKey("dBeconnect")? currentNodeMap.get("dBeconnect").contains("false")? false: true: false;
					node.dBeconnectID= currentNodeMap.containsKey("dBeconnectID")?Integer.parseInt(currentNodeMap.get("dBeconnectID")):0;
					node.dBeconnectPrimaryKey= currentNodeMap.containsKey("dBeconnectPrimaryKey")?currentNodeMap.get("dBeconnectPrimaryKey"):"null";
					node.dBeconnectX= currentNodeMap.containsKey("dBeconnectX")? Integer.parseInt(currentNodeMap.get("dBeconnectX")):0;
					node.dBeconnectY= currentNodeMap.containsKey("dBeconnectY")? Integer.parseInt(currentNodeMap.get("dBeconnectY")):0;
					node.dBeconnetName= currentNodeMap.containsKey("dBeconnetName")? currentNodeMap.get("dBeconnetName"):"null";
					node.flash= currentNodeMap.containsKey("flash")? Integer.parseInt(currentNodeMap.get("flash")):0;
					node.ID= currentNodeMap.containsKey("NodeID")? Integer.parseInt(currentNodeMap.get("NodeID")):0;
					node.leftChoose= currentNodeMap.containsKey("leftChoose")? currentNodeMap.get("leftChoose").contains("false")? false: true: false;
					node.mBeconnect= currentNodeMap.containsKey("mBeconnect")? currentNodeMap.get("mBeconnect").contains("false")? false: true: false;
					node.mBeconnectID= currentNodeMap.containsKey("mBeconnectID")? Integer.parseInt(currentNodeMap.get("mBeconnectID")):0;
					node.mBeconnectPrimaryKey= currentNodeMap.containsKey("mBeconnectPrimaryKey")? currentNodeMap.get("mBeconnectPrimaryKey"):"null";
					node.mBeconnectX= currentNodeMap.containsKey("mBeconnectX")? Integer.parseInt(currentNodeMap.get("mBeconnectX")):0;
					node.mBeconnectY= currentNodeMap.containsKey("mBeconnectY")? Integer.parseInt(currentNodeMap.get("mBeconnectY")):0;
					node.mBeconnetName= currentNodeMap.containsKey("mBeconnetName")?currentNodeMap.get("mBeconnetName"):"null";
					node.name= currentNodeMap.containsKey("NodeName")?currentNodeMap.get("NodeName"):"null";
					node.rightChoose= currentNodeMap.containsKey("rightChoose")? currentNodeMap.get("rightChoose").contains("false")? false: true: false;
					node.tBeconnect= currentNodeMap.containsKey("tBeconnect")? currentNodeMap.get("tBeconnect").contains("false")? false: true: false;
					node.tBeconnectID= currentNodeMap.containsKey("tBeconnectID")? Integer.parseInt(currentNodeMap.get("tBeconnectID")):0;
					node.tBeconnectPrimaryKey= currentNodeMap.containsKey("tBeconnectPrimaryKey")? currentNodeMap.get("tBeconnectPrimaryKey"):"null";
					node.primaryKey= currentNodeMap.containsKey("primaryKey")? currentNodeMap.get("primaryKey"):"null";
					node.tBeconnectX= currentNodeMap.containsKey("tBeconnectX")? Integer.parseInt(currentNodeMap.get("tBeconnectX")):0;
					node.tBeconnectY= currentNodeMap.containsKey("tBeconnectY")? Integer.parseInt(currentNodeMap.get("tBeconnectY")):0;
					node.tBeconnetName= currentNodeMap.containsKey("tBeconnetName")? currentNodeMap.get("tBeconnetName"):"null";
					node.x= currentNodeMap.containsKey("NodeCoordinationX")? Integer.parseInt(currentNodeMap.get("NodeCoordinationX")):0;
					node.y= currentNodeMap.containsKey("NodeCoordinationY")? Integer.parseInt(currentNodeMap.get("NodeCoordinationY")):0;
					node= thislist.addNodeOnlyWithFace(node, nodeView.first);
					node.thisFace.nodeConfiguration= currentNodeMap.containsKey("nodeConfiguration")? currentNodeMap.get("nodeConfiguration"):"null";
					node.thisFace.isConfiged= currentNodeMap.containsKey("isConfiged")? currentNodeMap.get("isConfiged").contains("false")? false: true: false;
					node.thisFace.isExecuted= currentNodeMap.containsKey("isExecuted")? currentNodeMap.get("isExecuted").contains("false")? false: true: false;	
					if(null== first) {
						first= node;
					}else {
						first.next= node;
						node.pre= first;
						first= first.next;
					}
					currentNodeMap.clear();
				}
			}
		}catch(Exception loadE) {
			loadE.printStackTrace();
		}
		first= Sort.sort(first);
		return first;	
	}
}