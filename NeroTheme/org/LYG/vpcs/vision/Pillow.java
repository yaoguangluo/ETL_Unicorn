package org.LYG.vpcs.vision;
import java.util.HashMap;
import java.util.Map;
import org.LYG.document.neroCell.BootNeroDoc;
public class Pillow{
	public static Map<Long, Object> pillowBase;
	public static void register(BootNeroDoc bootNeroDoc) {
		//bootNeroDoc 需要拿出来的数据资源，比如可重用数据，运维数据，可控数据等。
		Map<String, Object>map= new HashMap<>(); 
		//...
		bootNeroDoc.setPillow(map);
		pillowBase.put(bootNeroDoc.getId(), map);
	}
}