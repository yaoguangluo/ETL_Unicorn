package org.LYG.GUI.nodeEdit;
public class Sort{
	public Sort(){	
	}
	public LinkNode sort(LinkNode first){
		while(null != first && null != first.pre){
			first = first.pre;
		}
		return first;
	}
}