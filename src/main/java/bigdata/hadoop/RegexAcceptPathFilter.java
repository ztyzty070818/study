package bigdata.hadoop;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class RegexAcceptPathFilter implements PathFilter {

    private final String regex;

    public RegexAcceptPathFilter(String regex) {
        this.regex = regex;
    }


    @Override
    public boolean accept(Path path) {
        return path.toString().matches(regex);
    }


}
