package http;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpClient {
	static Logger logger = LoggerFactory.getLogger(HttpClient.class);

	static CloseableHttpClient httpClient;

	public static CloseableHttpClient getClient() {
		if (httpClient == null) {
			httpClient = HttpClients.createDefault();
		}
		return httpClient;
	}

	public static Response post(String url) throws IOException {
		return post(url, null);
	}

	public static Response post(String url, String params) {
		CloseableHttpClient httpClient = getClient();

		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
						.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
						.setSocketTimeout(60000)// 设置读取数据连接超时时间
						.build();
		httpPost.setConfig(requestConfig);
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("Connection", "Keep-Alive");

		if (null != params && params.length() > 0) {
			httpPost.setEntity(new StringEntity(params, "UTF-8"));
		}

		Response response = null;
		try {
			response = httpResponseTransform(httpClient.execute(httpPost));
		} catch (IOException e) {
			logger.error(String.valueOf(e));
		}
		logger.info("POST: " + url + "\tstatus code: " + response.getStatusCode());
		return response;
	}

	public static Response get(String url) throws IOException {
		CloseableHttpClient httpClient = getClient();

		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
						.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
						.setSocketTimeout(60000)// 设置读取数据连接超时时间
						.build();
		httpGet.setConfig(requestConfig);

		Response response = null;
		try {
			response = httpResponseTransform(httpClient.execute(httpGet));
		} catch (IOException e) {
			logger.error(String.valueOf(e));
		}
		logger.info("GET: " + url + "\tstatus code: " + response.getStatusCode());
		return response;
	}

	private static Response httpResponseTransform(HttpResponse httpResponse) throws IOException {
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		String result = EntityUtils.toString(httpResponse.getEntity());
		return new Response(statusCode, result);
	}
}
