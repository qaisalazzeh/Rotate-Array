package com.app.rotate.array;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author qazzeh
 *
 */
public class Solution {

	public static final String INPUT_FILE_PATH = System.getProperty("user.dir") + "/src/input.txt";
	public static HashMap<String, Object> map = new HashMap<String, Object>();

	public static void main(String[] args) {
		try {
			fetchFileIntoMap();
			rotateTheArray();
		} catch (IOException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void fetchFileIntoMap() throws FileNotFoundException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE_PATH));

		String line;
		String tempTestCase = null;
		while ((line = bufferedReader.readLine()) != null) {

			String tempLine = line;
			int spaces = tempLine.replaceAll("[^ ]", "").length();
			if (spaces == 1) {
				map.put(line, null);
				tempTestCase = line;
				continue;
			} else {
				if (tempTestCase != null) {
					map.put(tempTestCase, line);
					tempTestCase = null;
				}
			}

		}
		bufferedReader.close();
	}

	private static void rotateTheArray() {

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			String[] splited = key.split(" ");
			int arraySize = Integer.valueOf(splited[0]);
			int numberSizeOfRotation = Integer.valueOf(splited[1]);
			int[] array = getArray((String) entry.getValue(), arraySize);
			int[] tempArrayLast = Arrays.copyOfRange(array, 0, numberSizeOfRotation);
			int[] tempArrayFirst = Arrays.copyOfRange(array, numberSizeOfRotation, array.length);
			int tempArrayFirstLenght = tempArrayFirst.length;
			int tempArrayLastLenght = tempArrayLast.length;
			int[] result = new int[tempArrayFirstLenght + tempArrayLastLenght];
			System.arraycopy(tempArrayFirst, 0, result, 0, tempArrayFirstLenght);
			System.arraycopy(tempArrayLast, 0, result, tempArrayFirstLenght, tempArrayLastLenght);
			System.out.println(Arrays.toString(result));
		}

	}

	private static int[] getArray(String value, int arraySize) {
		int[] array = new int[arraySize];
		String[] val = value.split(" ");
		for (int i = 0; i < val.length; ++i) {
			array[i] = Integer.parseInt(val[i]);
		}
		return array;

	}

}
