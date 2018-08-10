package interval;


import java.util.TreeSet;

public class TestInterval {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(
                (lhs, rhs) -> {
                    if(lhs instanceof Integer && rhs instanceof Integer) {
                        return ((Integer) rhs).compareTo((Integer) lhs);
                    }
                    throw new IllegalArgumentException();
                }
        );

        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);

        System.out.println(treeSet);
    }
}
