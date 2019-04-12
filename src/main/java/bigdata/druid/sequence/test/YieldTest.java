package bigdata.druid.sequence.test;

import bigdata.druid.sequence.*;
import com.google.common.collect.ImmutableList;

import java.io.IOException;

/**
 * Created by zty on 18-11-6
 */
public class YieldTest {
	public static void main(String[] args) throws IOException {
		Sequence<String> sequence = Sequences.simple(ImmutableList.of("a","b","c"));

		Yielder<String> yielder = sequence.toYielder("1", new YieldingAccumulator<String, String>() {
			@Override
			public String accumulate(String accumulated, String in) {
				yield();
				return accumulated + "\n" + in;
			}
		});

		String item = yielder.get();
		System.out.println(yielder.get());

		while (!yielder.isDone()) {
			Yielder<String> oldYielder = yielder;
			yielder = yielder.next("2");
			oldYielder.close();
			System.out.println(yielder.get());
		}
		yielder.close();
	}
}
