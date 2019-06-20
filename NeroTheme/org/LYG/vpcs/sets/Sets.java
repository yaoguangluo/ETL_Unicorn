package org.LYG.vpcs.sets;
import java.util.HashMap;
import java.util.Map;
public class Sets{
	public static Map<Long, Object> setsMap;
	public static void register(long l) {
		Map<String, Object> map= new HashMap<>();
		setsMap.put(l, map);
	}
}