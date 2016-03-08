package com.taky.mapmo.common.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Test;

public class SecurityUtilsTest {
	@Test
	public void testCreateAccreditationUrl() throws Exception {
		String id = "mapmo";
		
		// 나노초까지 관리가능
		ZoneId locale = ZoneId.of("Asia/Seoul");
		ZonedDateTime time = ZonedDateTime.of(2016, 3, 8, 16, 46, 0, 0, locale);
		
		// 밀리초까지 관리 가능
		Date date = new Date(time.toInstant().toEpochMilli());
		
		String cipher = SecurityUtils.createAccreditationUrl(id, date);
		System.out.println(cipher);
	}
}
