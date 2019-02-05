package org.LYG.GUI.nodeView;

public class cacuString {
	public String cauString(String tr){
		String currentstr=new String("");
		if(tr.equals("Node")){return null;}
		char[] a = new char[tr.length()];
		for(int i=0;i<tr.length();i++) {
			a[i]=tr.charAt(i);
		}
		for(int i=0;i<tr.length();i++){
			if(a[i]=='t'&&a[i+1]=='e'&&a[i+2]=='x'&&a[i+3]=='t'){
				for(int j=i+5;a[j]!=',';j++){
					currentstr=currentstr+a[j];   
				}
				return currentstr;
			}
		}
		return currentstr;
	}
}
