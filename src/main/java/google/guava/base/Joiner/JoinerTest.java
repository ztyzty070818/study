package google.guava.base.Joiner;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.List;

public class JoinerTest {
    @Test
    public void Test() {
        Joiner joiner = Joiner.on('_');
        List<String> list = Lists.newArrayList("a","b",null);

        Map<String, String> map = Maps.newHashMap();
        map.put("1","a");
        map.put("2",null);
        map.put("3","c");

        System.out.println( joiner.skipNulls().join(list) );
        System.out.println( joiner.join(map.keySet()) );
    }
}
