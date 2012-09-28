package com.github.searls.jasmine.format;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class FormatsScriptTagsTest {
	private FormatsScriptTags subject = new FormatsScriptTags();
	
	@Test
	public void formatsOneScriptNicely() {
		String expected = "pants";
		
		String result = subject.format(new HashSet<String>(asList(expected)));
		
		assertThat(result,containsString(expectedScriptTagFormat(expected)));
	}
	
	@Test
	public void formatsTwoScriptsNicely() {
		String first = "A";
		String second = "B";
		
		String result = subject.format(new HashSet<String>(asList(first,second)));
		
		assertThat(result,containsString(expectedScriptTagFormat(first)+"\n"+expectedScriptTagFormat(second)));
	}

	@Test
	public void formatsInlineScriptNicely() {
		String inlineScript = "script:function() {};";
		String expected = "function() {};";
		
		String result = subject.format(new HashSet<String>(asList(inlineScript)));
		
		assertThat(result, containsString(expectedInlineScriptTagFormat(expected)));
	}
	
	private String expectedScriptTagFormat(String scriptName) {
		return expectedScriptTagFormat(scriptName, "text/javascript");
	}
	
	private String expectedScriptTagFormat(String scriptName, String scriptType) {
		return "<script type=\""+scriptType+"\" src=\""+scriptName+"\"></script>";
	}

	private String expectedInlineScriptTagFormat(String inlineScript) {
		return "<script type=\"text/javascript\">" + inlineScript  + "</script>";
	}
}
