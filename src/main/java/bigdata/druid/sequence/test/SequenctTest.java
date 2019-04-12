package bigdata.druid.sequence.test;

import bigdata.druid.sequence.Accumulator;
import bigdata.druid.sequence.Sequence;
import bigdata.druid.sequence.Sequences;
import com.google.common.collect.ImmutableList;

/**
 * Created by zty on 18-11-6
 */
public class SequenctTest {
	public static void main(String[] args) {
		Sequence<String> sequence = Sequences.simple(ImmutableList.of("a","b","c"));

		String output = sequence.accumulate("gg", new Accumulator<String, String>() {
			@Override
			public String accumulate(String accumulated, String in) {
				return accumulated + "\t" + in;
			}
		});

		System.out.println(output);
	}
}
