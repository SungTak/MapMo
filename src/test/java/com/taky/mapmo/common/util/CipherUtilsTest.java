package com.taky.mapmo.common.util;

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
	}
}
