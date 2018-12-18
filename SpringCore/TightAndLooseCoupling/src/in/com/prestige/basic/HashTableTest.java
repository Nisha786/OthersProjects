package in.com.prestige.basic;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashTableTest {
  public static void main(String[] args) {
	Map<String,String> m = new Hashtable<>();
	Collections.synchronizedMap(m);
	m.put("a", "A");
	m.put("b", "B");
	m.put("b", "C");
	m.put("c", "D");
	Iterator it = m.entrySet().iterator();
	while(it.hasNext()){
		Map.Entry<String,String> pair = (Map.Entry<String,String>)it.next();
		System.out.println(pair.getKey()+"--"+pair.getValue());
		//m.put("m", "M");
	}
}
}
