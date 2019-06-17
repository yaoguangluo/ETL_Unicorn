package org.LYG.document.neroCell;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextPane;

import org.LYG.GUI.extOSGI.OSGI_chansfer;
import org.LYG.GUI.nodeEdit.LinkNode;
public class BootNeroCell{
	public static void bootCell(LinkNode linkNode, JTextPane rightBotJTextPane) throws IOException, UnsupportedAudioFileException, InterruptedException {
		int totalCount= getTotalNodeCount(linkNode);
		Map<String, Boolean> bootedMaps= new HashMap<>();
		int bootCount= 0;
		//先进行根节点处理，再深度处理
		//准备写深度搜索来做神经流传导，先更新下版本 1.0.3_beta, 这几天完善。20190617 8：28 罗瑶光
		while(bootCount< totalCount) {
			LinkNode currentNode= linkNode;
			Here:
				while(null!= currentNode) {
					if(bootedMaps.containsKey(currentNode.primaryKey)) {
						currentNode= currentNode.next;
					}
					if(currentNode.tBeconnect&& !bootedMaps.containsKey(currentNode.tBeconnectPrimaryKey)) {
						continue Here;
					}
					if(currentNode.mBeconnect&& !bootedMaps.containsKey(currentNode.mBeconnectPrimaryKey)) {
						continue Here;
					}
					if(currentNode.dBeconnect&& !bootedMaps.containsKey(currentNode.dBeconnectPrimaryKey)) {
						continue Here;
					}
					bootCount+= 1;
					if(null!= currentNode.thisFace&& currentNode.thisFace.isConfiged) {
						//配置
						currentNode.thisFace.config(rightBotJTextPane);
						//取值
						new OSGI_chansfer(currentNode, linkNode);
						//运行
						currentNode.thisFace.execute(rightBotJTextPane);
						bootedMaps.put(currentNode.primaryKey, true);
					}else {
						//报没有配置异常；
						//弹出配置面板；
					}
					currentNode= currentNode.next;
				}
		}
	}

	private static int getTotalNodeCount(LinkNode linkNode) {
		int nodeCount= 0;
		LinkNode currentNode= linkNode;
		while(null!= currentNode) {
			nodeCount+= 1;
			currentNode= currentNode.next;
		}
		return nodeCount;
	}
}