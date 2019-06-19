package org.LYG.document.save;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileWriter;
import org.LYG.GUI.nodeEdit.LinkNode;
import org.LYG.sets.stable.StableData;
import comp.filenameFilter.TXTFilter;
//准备把响应事件移植到这里。
public class SaveAsANewFile{
	public static void Save(LinkNode first) {
		FileDialog filedialog= new FileDialog(new Frame(), StableData.DOC_CREATE, FileDialog.LOAD);
		filedialog.setFilenameFilter(new TXTFilter(StableData.FILE_FORMAT_ETL));
		filedialog.setVisible(true);
		String fileSavepath= filedialog.getDirectory()+ filedialog.getFile();
		System.out.println(fileSavepath);
		if(new File(fileSavepath).isFile()&& fileSavepath.contains(StableData.FILE_FORMAT_ETL)) {
			System.out.println(StableData.DOC_EXIST);
			return;
		}
		fileSavepath= fileSavepath+ StableData.FILE_FORMAT_ETL;
		System.out.println(fileSavepath);
		//create file and save
		try {
			FileWriter fileWriter= new FileWriter(fileSavepath);
			LinkNode node= first;
			while(null!= node) {
				//挨个取。没难度。逐个把信息写入文件。
				//节点坐标，节点名， 节点关联，
				String NodeCoordinationX= ""+ node.x;
				String NodeCoordinationY= ""+ node.y;
				String NodeName= ""+ node.name;
				String NodeID=""+ node.ID;
				String flash=""+ node.flash;
				String beconnect= ""+ node.beconnect;
				String leftChoose= ""+ node.leftChoose;
				String rightChoose= ""+ node.rightChoose;
				String tBeconnect= ""+ node.tBeconnect;
				String tBeconnectX= ""+ node.tBeconnectX;
				String tBeconnectY= ""+ node.tBeconnectY;
				String tBeconnetName= ""+ node.tBeconnetName;
				String tBeconnectID= ""+ node.tBeconnectID;
				String tBeconnectPrimaryKey= ""+ node.dBeconnectPrimaryKey;
				String mBeconnect= ""+ node.mBeconnect;
				String mBeconnectX= ""+ node.mBeconnectX;
				String mBeconnectY= ""+ node.mBeconnectY;
				String mBeconnetName= ""+ node.mBeconnetName;
				String mBeconnectID= ""+ node.mBeconnectID;
				String mBeconnectPrimaryKey= ""+ node.mBeconnectPrimaryKey;
				String dBeconnect= ""+ node.dBeconnect;
				String dBeconnectX= ""+ node.dBeconnectX;
				String dBeconnectY= ""+ node.dBeconnectY;
				String dBeconnetName= ""+ node.dBeconnetName;
				String dBeconnectID= ""+ node.dBeconnectID;
				String dBeconnectPrimaryKey= ""+ node.dBeconnectPrimaryKey;
				String primaryKey= ""+ node.primaryKey;
				String nodeConfiguration= ""+ node.thisFace.nodeConfiguration;
				String isConfiged= ""+ node.thisFace.isConfiged;
				String isExecuted= ""+ node.thisFace.isExecuted;
				//配置
				fileWriter.write("\r\n");
				fileWriter.write("NodeCoordinationX:"+ NodeCoordinationX);
				fileWriter.write("\r\n");
				fileWriter.write("NodeName:"+ NodeName);
				fileWriter.write("\r\n");
				fileWriter.write("NodeCoordinationY:"+ NodeCoordinationY);
				fileWriter.write("\r\n");
				fileWriter.write("NodeID:"+ NodeID);
				fileWriter.write("\r\n");
				fileWriter.write("flash:"+ flash);
				fileWriter.write("\r\n");
				fileWriter.write("beconnect:"+ beconnect);
				fileWriter.write("\r\n");
				fileWriter.write("leftChoose:"+ leftChoose);
				fileWriter.write("\r\n");
				fileWriter.write("rightChoose:"+ rightChoose);
				fileWriter.write("\r\n");
				fileWriter.write("tBeconnect:"+ tBeconnect);
				fileWriter.write("\r\n");
				fileWriter.write("tBeconnectX:"+ tBeconnectX);
				fileWriter.write("\r\n");
				fileWriter.write("tBeconnectY:"+ tBeconnectY);
				fileWriter.write("\r\n");
				fileWriter.write("tBeconnetName:"+ tBeconnetName);
				fileWriter.write("\r\n");
				fileWriter.write("tBeconnectID:"+ tBeconnectID);
				fileWriter.write("\r\n");
				fileWriter.write("tBeconnectPrimaryKey:"+ tBeconnectPrimaryKey);
				fileWriter.write("\r\n");
				fileWriter.write("mBeconnect:"+ mBeconnect);
				fileWriter.write("\r\n");
				fileWriter.write("mBeconnectX:"+ mBeconnectX);
				fileWriter.write("\r\n");
				fileWriter.write("mBeconnectY:"+ mBeconnectY);
				fileWriter.write("\r\n");
				fileWriter.write("mBeconnetName:"+ mBeconnetName);
				fileWriter.write("\r\n");
				fileWriter.write("mBeconnectID:"+ mBeconnectID);
				fileWriter.write("\r\n");
				fileWriter.write("mBeconnectPrimaryKey:"+ mBeconnectPrimaryKey);
				fileWriter.write("\r\n");
				fileWriter.write("dBeconnect:"+ dBeconnect);
				fileWriter.write("\r\n");
				fileWriter.write("dBeconnectX:"+ dBeconnectX);
				fileWriter.write("\r\n");
				fileWriter.write("dBeconnectY:"+ dBeconnectY);
				fileWriter.write("\r\n");
				fileWriter.write("dBeconnetName:"+ dBeconnetName);
				fileWriter.write("\r\n");
				fileWriter.write("dBeconnectID:"+ dBeconnectID);
				fileWriter.write("\r\n");
				fileWriter.write("dBeconnectPrimaryKey:"+ dBeconnectPrimaryKey);
				fileWriter.write("\r\n");
				fileWriter.write("primaryKey:"+ primaryKey);
				fileWriter.write("\r\n");
				fileWriter.write("nodeConfiguration:"+ nodeConfiguration);
				fileWriter.write("\r\n");
				fileWriter.write("isConfiged:"+ isConfiged);
				fileWriter.write("\r\n");
				fileWriter.write("isExecuted:"+ isExecuted);
				fileWriter.write("\r\n");
				//分割
				String split="##############################";
				fileWriter.write("\r\n");
				fileWriter.write(split);
				fileWriter.flush();
				if(null== node.next) {
					break;
				}
				node= node.next;
			}	
			fileWriter.close();
		}catch(Exception saveFile) {
		}
	}
}