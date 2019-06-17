package org.LYG.node.ai.arffTransfer;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.*;
import org.LYG.GUI.OSGI.*;
import org.json.JSONObject;
public class arffTransferNodeInterface extends ObjectInterface{	
	public arffTransferNodeInterface() throws IOException{
		thisIcon= new ImageIcon(this.getClass().getResource("1.jpg"));
		thisName= new String("arffTransfer");
		position= new String("BI");
		Image img= ((ImageIcon) thisIcon).getImage();  
		Image newimg= img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage= img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon= new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane) throws IOException{
		//节点的逻辑大家自己写。如果配置数据带有 : 等符号就encode，decode一下，哥就不啰嗦了。
		memoryRecovery(jTextPane);//档案可以读
		thisNodeConfig();
		memoryRecord(jTextPane);//档案可以写
		this.isConfiged= true;//这句话千万别删，这是档案神经流自动执行的重要观测关键字。
	}

	private void thisNodeConfig() throws IOException {
		//节点的逻辑大家自己写。如果配置数据带有 : 等符号就encode，decode一下，哥就不啰嗦了。
		thisView= new arffTransferNodeView();
		thisRun= new arffTransferNodeRun();
		thisPanel= new arffTransferNodePanel((arffTransferNodeRun) thisRun);
		thisPanel.config();
		showed= false;
	}
	public void execute(JTextPane jTextPane) throws FileNotFoundException, IOException{
		((arffTransferNodeRun) thisRun).run((arffTransferNodeView) thisView);
		this.isExecuted= true;
	}
	public void view(JTextPane jTextPane) throws Exception{
		thisView.view();
		showed= true;
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException {
		thisInterface= new arffTransferNodeInterface();
		return thisInterface;  
	}
	private void memoryRecovery(JTextPane jTextPane) {
		//准备增加检查 nodeConfiguration 是否有配置
		try {
			if(null!= nodeConfiguration) {
				//如果有，就自动配置，有没有都可以弹出面板来操作配置。
				nodeConfigurationMap= new LinkedHashMap<>();
				JSONObject jSONObject= new JSONObject(nodeConfiguration);
				Iterator<String> iterator= jSONObject.keys();
				//写自动配置的 JSON String to MAP 函数来取操作数。
				while(iterator.hasNext()) {
					String string= iterator.next();
					nodeConfigurationMap.put(string, jSONObject.getString(string));
				}
			}
		}catch(Exception e) {
			jTextPane.setText(e.getStackTrace().toString());
			jTextPane.validate();
		}
		//罗瑶光注释：20190612
	}

	private void memoryRecord(JTextPane jTextPane) {
		try {
			if(null== nodeConfigurationMap) {
				nodeConfigurationMap= new LinkedHashMap<>(); 
			}
			if(null!= nodeConfigurationMap) {
				//如果有，就自动配置，有没有都可以弹出面板来操作配置。
				JSONObject jSONObject= new JSONObject();
				Iterator<String> iterator= nodeConfigurationMap.keySet().iterator();
				//写自动配置的 JSON String to MAP 函数来取操作数。
				while(iterator.hasNext()) {
					String string= iterator.next();
					jSONObject.put(string, nodeConfigurationMap.get(string));
				}
				jSONObject.put("END", "SURE");
				nodeConfiguration= jSONObject.toString();
			}
		}catch(Exception e) {
			jTextPane.setText(e.getStackTrace().toString());
			jTextPane.validate();
		}
		//罗瑶光注释：20190613
	}
}
