package org.LYG.vpcs.hallKeeper;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextPane;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeView.NodeShow;
import org.LYG.document.neroCell.BootNeroDoc;
import org.LYG.vpcs.skivvy.Skivvy;
import org.LYG.vpcs.vision.Pillow;
import org.LYG.vpcs.vision.Vision;
public class HallKeeper{
	public static Map<Long, BootNeroDoc> hallKeeper;
	public static void vpcsRegister(LinkList first, String fileCurrentpath, NodeShow nodeView
			, JTextPane rightBotJTextPane) {
		if(null== hallKeeper) {
			hallKeeper= new HashMap<>();
		}
		BootNeroDoc bootNeroDoc= new BootNeroDoc(first, fileCurrentpath, nodeView, rightBotJTextPane);
		Vision.register(bootNeroDoc);
		Pillow.register(bootNeroDoc);
		if(200> hallKeeper.size()) {
			hallKeeper.put(bootNeroDoc.getId(), bootNeroDoc);
			try {
				bootNeroDoc.start();
			}catch(Exception e) {
				Skivvy.working(hallKeeper, e);
			}
		}
	}
}