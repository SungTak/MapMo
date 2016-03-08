package com.taky.mapmo.common.util;

import java.util.Date;

public class SecurityUtils {
	public static String createAccreditationUrl(String id, Date date) throws Exception {
		String mix = date.getTime() + id;

		return "http://localhost:8080/accreditation/"+ CipherUtils.makeSHA256(mix).toString();
	}
}
