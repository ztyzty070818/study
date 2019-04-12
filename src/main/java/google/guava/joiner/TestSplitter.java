package google.guava.joiner;

import com.google.common.base.Splitter;


/**
 * Created by zty on 18-8-14
 */
public class TestSplitter {
	public static void main(String[] args) {
		System.out.println(Splitter.on(",").split("a,b,c,,"));

		String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";

		System.out.println(Splitter.on("#").withKeyValueSeparator("=").split(startString));

	}
}
