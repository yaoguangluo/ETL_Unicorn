package org.LYG.GUI.nodeView;
public class CacuString {
	//因未加速计算，所以算子名不进行码农的修养化
	public String cauString(String string){
		StringBuilder stringBuilder= new StringBuilder();
		if(string.equals("Node")){return null;}
		char[] a=string.toCharArray();
		for(int i= 0; i< string.length(); i++){
			if(a[i]== 't' && a[i+ 1]== 'e' && a[i+ 2]== 'x' && a[i+ 3]== 't'){
				for(int j= i+ 5; a[j]!= ','; j++){
					stringBuilder.append(a[j]);   
				}
				return stringBuilder.toString();
			}
		}
		return stringBuilder.toString();
	}
}
