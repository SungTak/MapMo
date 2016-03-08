package com.taky.mapmo.common.util;

import java.util.Date;

import com.taky.mapmo.common.constant.Constants;

public class SecurityUtils {
	public static String createAccreditationUrl(String id, Date date) throws Exception {
		String mix = date.getTime() + id;

		return Constants.MAPMO_DOMAIN + CipherUtils.makeSHA256(mix).toString();
	}
}
