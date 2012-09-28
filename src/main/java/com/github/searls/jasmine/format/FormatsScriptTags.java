package com.github.searls.jasmine.format;

import java.util.Set;

public class FormatsScriptTags {

	private static final String SCRIPT_PROTOCOL = "script:";
	private static final int STRIP_SCRIPT_PROTOCOL_INDEX_START = SCRIPT_PROTOCOL.length();
	
	public String format(Set<String> sourceLocations) {
		StringBuilder sb = new StringBuilder();
		
		for (String location : sourceLocations) {
			if (location.startsWith(SCRIPT_PROTOCOL)) {
				String inlineScript = stripScriptProtocol(location);
				sb.append("<script type=\"text/javascript\">").append(inlineScript).append("</script>").append("\n");
			} else {
				sb.append("<script type=\"text/javascript\" src=\"").append(location).append("\"></script>").append("\n");
			}
		}
		return sb.toString();
	}

	private String stripScriptProtocol(String inlineScript) {
		return inlineScript.substring(STRIP_SCRIPT_PROTOCOL_INDEX_START);
	}
}
