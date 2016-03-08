package com.taky.mapmo.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CipherUtils {

	public static byte[] makeSHA256(String target) throws Exception {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(target.getBytes(Charset.forName("UTF-8")));

			return Base64.getEncoder().encode(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e);
		}
	}
}
