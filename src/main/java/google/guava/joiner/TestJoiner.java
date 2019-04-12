package google.guava.joiner;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import java.util.Map;

/**
 * Created by zty on 18-8-14
 */
public class TestJoiner {
	public static void main(String[] args) {
		Joiner joiner = Joiner.on("; ").skipNulls();
		Joiner joiner1 = Joiner.on("; ").useForNull("D");
		System.out.println(joiner.join("C",null,"B"));
		System.out.println(joiner1.join("C",null,"B"));

		Map<String,String> testMap = Maps.newLinkedHashMap();
		testMap.put("Washington D.C","Redskins");
		testMap.put("New York City","Giants");
		testMap.put("Philadelphia","Eagles");
		testMap.put("Dallas","Cowboys");

		System.out.println(Joiner.on("\n").withKeyValueSeparator(" == ").join(testMap));
	}
}
