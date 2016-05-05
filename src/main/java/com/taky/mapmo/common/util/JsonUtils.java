package com.taky.mapmo.common.util;

import java.util.Map;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import com.taky.mapmo.map.model.MapInfo;

public class JsonUtils {
	public MapInfo convertTo(String json) {
		JsonParser jsonParser = JsonParserFactory.getJsonParser();
		Map<String, Object> result = jsonParser.parseMap(json);
		
		return null;
	}
}
