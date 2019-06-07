package org.LYG.node.ai.arffTransfer;
public class arffNode{ 
	public String thisName;
	public arffNode next;
	public arffNode pre;
	public arffNode(){
		next=null;
		pre=null;
		thisName=null;
	}
	public void addName(String name){
		next=null;
		pre=null;
		thisName=name;
		thisName=new String(name);
	}
}