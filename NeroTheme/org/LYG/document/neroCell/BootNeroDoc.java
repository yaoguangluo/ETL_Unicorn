package org.LYG.document.neroCell;
import java.io.File;
import java.util.Map;
import javax.swing.JTextPane;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeEdit.LinkNode;
import org.LYG.GUI.nodeView.NodeShow;
import org.LYG.document.load.LoadFile;
import org.LYG.sets.stable.StableData;
@SuppressWarnings("unused")
public class BootNeroDoc extends Thread implements Runnable{
	private String fileCurrentpath;
	private LinkList first;
	private LinkNode currentNode;
	private NodeShow nodeView;
	private JTextPane rightBotJTextPane;
	private Map<String, Object> map;
	public BootNeroDoc(LinkList first, String fileCurrentpath, NodeShow nodeView
			, JTextPane rightBotJTextPane) {
		this.fileCurrentpath= fileCurrentpath;
		this.first= first;
		this.rightBotJTextPane= rightBotJTextPane;
	}
	public void setPillow(Map<String, Object> map) {
		this.map= map;//map 提供运维，可控等数据
	}
	public void run() {
		try {
			System.out.println(fileCurrentpath);
			if(null== fileCurrentpath|| fileCurrentpath.isEmpty()
					|| !fileCurrentpath.contains(StableData.FILE_FORMAT_ETL)) {
				System.out.println(StableData.ATTENSION_RECHOICE);
				return;
			}
			File file= new File(fileCurrentpath);
			if(!file.isFile()) {
				System.out.println(StableData.ATTENSION_RECHOICE);
				return;
			}
			Thread.sleep(2);
			currentNode= LoadFile.Load(currentNode, nodeView, file, first);
			Thread.sleep(2);
			BootNeroCell.bootCell(currentNode, rightBotJTextPane);
		}catch(Exception loadE) {
			loadE.printStackTrace();
		}
	}
}