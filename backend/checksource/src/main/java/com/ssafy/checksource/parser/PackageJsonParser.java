package com.ssafy.checksource.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ssafy.checksource.model.dto.ParsingDTO;

public class PackageJsonParser {
	private List<ParsingDTO> depenList;

	public PackageJsonParser(String json) {
		depenList = new ArrayList<ParsingDTO>();
		parse(json);

	}

	private void parse(String json) {
		JsonObject jsonObject = (JsonObject) JsonParser.parseString(json);
		JsonElement depenElement = jsonObject.get("dependencies");
		JsonObject depenObject = null;
		if(depenElement == null) {
			return;
		}
		else if(depenElement.isJsonObject()) {
			depenObject = (JsonObject) depenElement;
		}
		else if(depenElement.isJsonNull()) {
			return;
		}
		else {
			return;
		}
		
		
		for (String depenName : depenObject.keySet()) {
			ParsingDTO depen = new ParsingDTO();
			depen.setGroupId("");
			depen.setArtifactId(depenName);
			depen.setVersion(depenObject.get(depenName).getAsString());
			depenList.add(depen);
		}

	}
//	JsonObject

	public List<ParsingDTO> getDepenList() {
		return depenList;
	}

}
