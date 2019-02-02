package org.LYG.GUI.nodeEdit;
public class Sort{
	public Sort(){	
	}
	public LinkNode sort(LinkNode first2){
		while(first2 != null&&first2.pre!=null){
			first2 = first2.pre;
		}
		return first2;
	}
}