package bigdata.hadoop.configuration;

/**
 * Created by zty on 18-12-7
 */
public class DimensionSpec {
	private String type;
	private String name;
	private String format;

	public DimensionSpec(String name, String type, String format) {
		this.name = name;
		this.type = type;
		this.format = format;
	}

	public DimensionSpec(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getFormat() {
		return format;
	}
}
