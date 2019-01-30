package org.LYG.node.ai.arffTransfer;
public class arffNode{ 
	public String thisname;
	public arffNode next;
	public arffNode pre;
	public arffNode(){
		next=null;
		pre=null;
		thisname=null;
	}
	public void addName(String name){
		next=null;
		pre=null;
		thisname=name;
		thisname=new String(name);
	}
}