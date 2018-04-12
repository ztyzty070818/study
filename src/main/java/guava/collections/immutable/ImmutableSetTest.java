package guava.collections.immutable;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.UnmodifiableIterator;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

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
