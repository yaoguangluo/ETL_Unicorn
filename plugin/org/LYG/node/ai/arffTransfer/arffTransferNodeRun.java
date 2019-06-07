package org.LYG.node.ai.arffTransfer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.LYG.GUI.OSGI.*;
public class arffTransferNodeRun extends ObjectRun{
	private static final long serialVersionUID = 1L;
	public int value = 0;
	public String filepath;
	public arffTransferNodeRun( ) throws IOException{	
	}
	public void run(final arffTransferNodeView thisView) throws IOException{
		System.out.println("runed" + value); 
		System.out.println(toptablein.getModel().getValueAt(0, 0));
		System.out.println("runed" + value);
		File file = new File(filepath);  
		file.createNewFile();
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"GBK"));  
		arffLink link=new arffLink();
		arffNode node=new arffNode();
		wr.write("@relation "+"'ARFF'"+"\n");  
		for(int i=0;i<toptablein.getModel().getColumnCount();i++){
			if(toptablein.getModel().getColumnName(i).contains("String")){
				wr.write("@attribute " + "'" + toptablein.getModel().getColumnName(i) + i + "'" + " {");
				for(int j=0; j<toptablein.getModel().getRowCount(); j++){
					Object obj = toptablein.getModel().getValueAt(j, i);
					if(obj != null) {
						if(!link.search(node, obj.toString())){
							link.addNode(node, obj.toString());
							wr.write("'"+obj.toString()+"'");
							wr.write(",");
						}
					} 
				}
				wr.write("}\n");
			}

			if(toptablein.getModel().getColumnName(i).contains("Number")){
				wr.write("@attribute "+"'"+toptablein.getModel().getColumnName(i)+i+"'"+" real");
				wr.write("\n");
			}
			
			if(toptablein.getModel().getColumnName(i).contains("Date")){
				wr.write("@attribute "+"'"+toptablein.getModel().getColumnName(i)+i+"'"+" string");
				wr.write("\n");
			}
		}
		wr.write("@data\n");    
		for(int i=0; i<toptablein.getModel().getRowCount(); i++){
			for(int j=0; j<toptablein.getModel().getColumnCount();j++){
				if(toptablein.getModel().getColumnName(j).contains("String")
						||toptablein.getModel().getColumnName(j).contains("Date")){
					Object obj = toptablein.getModel().getValueAt(i, j);
					if(obj != null) {
						wr.write("'"+obj.toString()+"'");
						wr.write(",");
					}
				}else{
					Object obj = toptablein.getModel().getValueAt(i, j);
					if(obj != null) {
						wr.write(obj.toString());
						wr.write(",");
					}	 
				}
			}
			wr.write("\n");
		}
		System.out.println("===完成省份：");    
		System.out.println("全部完成。。。。。。。。");  
		wr.flush();  
		wr.close(); 	  
		thisView.tableout=toptablein;
		//thisView.out=new JTable(content,spec); 	
	}
}
