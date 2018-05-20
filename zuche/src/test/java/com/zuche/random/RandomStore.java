package com.zuche.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;

public class RandomStore {

	/**
	 * @Title: randomLonLat
	 * @Description: 在矩形内随机生成经纬度
	 * @param MinLon
	 *            ：最新经度 MaxLon： 最大经度 MinLat：最新纬度 MaxLat：最大纬度 type：设置返回经度还是纬度
	 * @return
	 * @throws
	 */
	private static String getLatAndLon(double MinLon, double MaxLon,
			double MinLat, double MaxLat, String type) {
		Random random = new Random();
		BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon)
				+ MinLon);
		String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
		db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
		String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
		if (type.equals("Lon")) {
			return lon;
		} else {
			return lat;
		}
	}

	/**
	 * 生成地址
	 * @return arr[0]：地址，arr[1]：经度，arr[2]：维度
	 */
	public static String[] getGdAddress() {
		String lat = null;
		String lng = null;
		String address = null;
		String province = null;
		while (province == null || !province.equals("广东省")) {
			lat = RandomStore.getLatAndLon(109.45, 117.20, 20.12, 25.31, "Lat");
			lng = RandomStore.getLatAndLon(109.45, 117.20, 20.12, 25.31, "Lon");
			
			String jsonString = getAddressJson(lat, lng);
			JSONObject topJson = JSONObject.parseObject(jsonString); 
			JSONObject resultJson = JSONObject.parseObject(topJson.getString("result"));
			JSONObject addressJson = JSONObject.parseObject(resultJson.getString("addressComponent"));
			address = resultJson.getString("formatted_address");
			province = addressJson.getString("province");
		}
		
		return new String[] {address, lat, lng};
	}
	
	private static String getAddressJson(String lat, String lng) {
		String key = "HHNwksT3c9XuGE9iwPrL0LLgSF0KzQsg";
		StringBuffer buffer = new StringBuffer(
				"http://api.map.baidu.com/geocoder/v2/?ak=");
		buffer.append(key);
		buffer.append("&location=");
		buffer.append(lat + "," + lng);
		buffer.append("&output=json&pois=1");

		StringBuilder json = new StringBuilder();
		try {
			URL url = new URL(buffer.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String jsonString = json.toString();
		return jsonString;
	}
	
	private static String[] firstDesc =  {"这是一家历史悠久的门店，","这是一家客户好评的门店，","这是一家服务至上的门店，"};
	private static String[] secondDesc =  {"我们拥有非常庞大的客户群，","欢迎前来租车，","不花客户一分冤枉钱，"};
	private static String[] thirdDesc =  {"安安心心出门去，平平安安回家来！","祝您工作顺利，心想事成！","我们竭诚为您服务！"};
	public static String getDescription() {
		return firstDesc[(int)(Math.random() * 4 - 1)] + 
				secondDesc[(int)(Math.random() * 4 - 1)] +
				thirdDesc[(int)(Math.random() * 4 - 1)];
	}
	
	private static String[] firstTraffic =  {"乘坐1路公交车，","乘坐2路公交车，","乘坐3路公交车，"};
	private static String[] secondTraffic =  {"乘坐101巴士，","乘坐102巴士，","乘坐103巴士，"};
	public static String getTraffic() {
		return firstTraffic[(int)(Math.random() * 4 - 1)] + 
				secondTraffic[(int)(Math.random() * 4 - 1)] +
				"在门店正门下车！";
	}
	
	public static Integer getTotalComment() {
		return (int)(Math.random() * 1000 + 1);
	}
	
	public static float getAvgStar() {
		BigDecimal b = new BigDecimal(Math.random() * 5);
		float f = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
		return f;
	}
	
	public static Integer getStatus() {
		return (int) (Math.random() * 2 + 1);
	}
	
	private static String[] startDateString = {"6:00","6:30","7:00","7:30","8:00","8:30","9:00",
			"9:30","10:00","10:30"};
	public static Date getStartDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String dateString = startDateString[(int)(Math.random() * (startDateString.length + 1) - 1)];
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	private static String[] endDateString = {"17:00","17:30","18:00","18:30","19:00",
		"19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30","00:00"};
	public static Date getEndDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String dateString = endDateString[(int)(Math.random() * (endDateString.length + 1) - 1)];
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
