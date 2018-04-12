package guava.base.function;

import com.google.common.base.Function;
import org.junit.Test;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FunctionTest {
    @Test
    public void testFunction() {
        Function<Date, String> function = new Function<Date, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Date date) {
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            }
        };
        System.out.println(function.apply(new Date()));

        Function<Map<String, String>,  String> subString = new Function<Map<String, String>, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Map<String, String> stringIntegerMap) {
                return stringIntegerMap.get("string").substring(Integer.parseInt(stringIntegerMap.get("integer")));
            }
        };

        Map<String, String> map = new HashMap<>();
        map.put("string", "123456789");
        map.put("integer", "3");

        System.out.println(subString.apply(map));
    }
}
