package org.LYG.vpcs.hallKeeper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JTextPane;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeView.NodeShow;
import org.LYG.document.neroCell.BootNeroDoc;
import org.LYG.vpcs.sets.Sets;
import org.LYG.vpcs.skivvy.Skivvy;
import org.LYG.vpcs.vision.Pillow;
import org.LYG.vpcs.vision.Vision;
public class HallKeeper{
	public static Map<Long, BootNeroDoc> hallKeeper;
	public static void vpcsRegister(LinkList first, String fileCurrentpath, NodeShow nodeView
			, JTextPane rightBotJTextPane) {
		if(null== hallKeeper) {
			hallKeeper= new ConcurrentHashMap<>();
		}
		if(200> hallKeeper.size()) {
			try {
				BootNeroDoc bootNeroDoc= new BootNeroDoc(first, fileCurrentpath, nodeView, rightBotJTextPane);
				Sets.register(bootNeroDoc.getId());//sets 是sleeper运行时候里面可以分离出来的数据。
				Pillow.register(bootNeroDoc);//pillow是这些数据的分类存储器
				Vision.registerVision(bootNeroDoc);//vision是sleeper运行的具体梦境。
				hallKeeper.put(bootNeroDoc.getId(), bootNeroDoc);
				bootNeroDoc.start();
			}catch(Exception e) {
				Skivvy.working(hallKeeper, e);//skivvy负责vision， pillow，sets，sleeper 全程管理和反馈。
			}
		}
	}
}