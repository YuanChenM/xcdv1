package com.msk.core.file;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 从json文件读取数据，形成JSon对象
 */
public class JSonParser {

	public static void main(String[] args) {
		// 从JSon文件读取数据
		StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("json.txt")));
			while ((line = br.readLine()) != null) {
				stringBuffer.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			// 将Json文件数据形成JSONObject对象
			JSONObject jsonObject = new JSONObject(stringBuffer.toString());
			// 获取JSONObject对象数据并打印
			JSONArray provinces = jsonObject.getJSONArray("provinces");
			String name = null;
			StringBuffer jsonFileInfo = new StringBuffer();
			JSONArray citys = null;
			for (int i = 0; i < provinces.length(); i++) {
				name = provinces.getJSONObject(i).getString("name");
				jsonFileInfo.append("/nname:" + name + "/n" + "citys:");
				citys = provinces.getJSONObject(i).getJSONArray("citys");
				for (int j = 0; j < citys.length(); j++) {
					jsonFileInfo.append(citys.getString(j) + "/t");
				}
			}

			// System.out.println(jsonFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
