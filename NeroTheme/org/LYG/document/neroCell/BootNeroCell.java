package org.LYG.document.neroCell;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextPane;

import org.LYG.GUI.extOSGI.OSGI_chansfer;
import org.LYG.GUI.nodeEdit.LinkNode;
public class BootNeroCell{
	@SuppressWarnings("unused")
	public static void bootCell(LinkNode linkNode, JTextPane rightBotJTextPane) throws IOException, UnsupportedAudioFileException, InterruptedException {
		Map<String,String> nodeMaps= new HashMap<>();
		//先进行根节点处理，再深度处理
		LinkNode currentNode= linkNode;
		while(null!= currentNode) {
			if(!currentNode.beconnect&& null!= currentNode.thisFace&& !currentNode.thisFace.nodeConfiguration.isEmpty()) { //我之后会设计一套规范出来
				//配置
				currentNode.thisFace.config(rightBotJTextPane);
				//取值
				new OSGI_chansfer(currentNode, linkNode);
				//运行
				currentNode.thisFace.execute(rightBotJTextPane);
			}
		}
		//准备写深度搜索来做神经流传导，先更新下版本 1.0.3_beta, 这几天完善。20190617 8：28 罗瑶光
		
 	}
}