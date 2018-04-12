package guava.collections.extra.table;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTest {
    public static void main(String[] args) {
        Table<String,Integer,String> table = HashBasedTable.create();
        table.put("a",1,"b");
        table.put("c",2,"d");
        table.put("a",2,"b");
        table.put("a",2,"F");
        table.put("a",2,"F");
        table.put("d",1,"F");

        System.out.println(table);
        System.out.println(table.rowMap());
        System.out.println(table.cellSet());
        System.out.println(table.size());
        System.out.println(table.values());
        System.out.println(table.row("a"));
        System.out.println(table.column(1));
        System.out.println(table.get("a",2));
    }
}
