package google.guava.collections.immutable;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

import java.util.Set;

public class ImmutableSetTest {
    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red","blue", "yello", "green"
    );

    public static void main(String[] args) {
        Set<String> copySet = ImmutableSet.copyOf(COLOR_NAMES);

        ImmutableSet<String> immutableSet;

        immutableSet = ImmutableSortedSet.of("a", "d", "c", "a", "d", "b");
        immutableSet = ImmutableSortedSet.copyOf(immutableSet);

        Set<String> set = ImmutableSortedSet.of("a", "d", "c", "a", "d", "b");

        System.out.println(set);
        System.out.println(immutableSet);
    }


}
