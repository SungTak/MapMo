package com.taky.mapmo.common.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	public static String request(String requestUrl) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(requestUrl);

		// TODO 키 숨기자 -ㅅ-ㅋ
		request.addHeader("X-Naver-Client-Id", "");
		request.addHeader("X-Naver-Client-Secret", "");

		try {
			HttpResponse response = client.execute(request);

			return EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.error("#### Connection하지 못했습니다!", e);
		} catch (Exception e) {
			logger.error("#### Request 과정에서 에러가 발생했습니다!", e);
		}

		return "";
	}
}
