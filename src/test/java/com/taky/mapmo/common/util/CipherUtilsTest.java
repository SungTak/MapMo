package com.taky.mapmo.common.util;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CipherUtilsTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testMakeSHA256() throws Exception {
		// SHA-256은 hash라 복호화가 불가하다고 한다..
		byte[] ciper = CipherUtils.makeSHA256("1234567890mapmo");
		
		logger.debug(ciper.toString());
		
		// 아파치 라이브러리 이용
		String digest1 = DigestUtils.sha256Hex("20072725" + "윤성탁짱");
		String digest2 = DigestUtils.sha256Hex("20072725" + "윤성탁짱");
		System.out.println(digest1 + ":" + digest2);
		
		assertEquals(digest1, digest2);
	}
}
