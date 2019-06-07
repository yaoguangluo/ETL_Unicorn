package org.LYG.node.ai.arffTransfer;
public class arffLink{
	public boolean search(arffNode first2, String key){
		while(first2 != null && first2.pre != null){
			first2 = first2.pre;
		}
		if(first2 == null || first2.thisName == null){
			return false;
		}
		if(first2.thisName.equals(key)){
			return true;
		}
		while(first2.next != null){
			first2 = first2.next;
			if(first2.thisName.equals(key)){
				while(first2.pre != null){
					first2 = first2.pre;
				}
				return true;
			}
		}
		return false;
	}

	public arffNode addNode(arffNode currentnode, String name) {
		if(currentnode == null){
			currentnode = new arffNode();
			currentnode.addName(name);
			currentnode.next = null;
			currentnode.pre = null;
			return currentnode;
		}
		while(currentnode.next != null){
			currentnode = currentnode.next;
		}
		arffNode node = new arffNode();
		node.addName(name);
		node.pre = currentnode;
		currentnode.next = node;
		while(currentnode.pre != null){
			currentnode = currentnode.pre;
		}
		return currentnode;
	} 
}