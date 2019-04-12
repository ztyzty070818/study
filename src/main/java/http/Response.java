package http;

/**
 * Created by zty on 18-12-6
 */
public class Response {
	private int statusCode;
	private String result;

	public Response(int statusCode, String result) {
		this.statusCode = statusCode;
		this.result = result;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getResult() {
		return result;
	}
}
