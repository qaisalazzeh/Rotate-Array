package com.app.rotate.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {

	public static void main(String[] args) {
		Pattern arraysInfoLineP = Pattern.compile("[0-9] [0-9]$");
		String test = "77 69";
		Matcher matcher = arraysInfoLineP.matcher(test);
		System.out.println(matcher.find());
	}
}
