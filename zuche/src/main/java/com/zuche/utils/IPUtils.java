package com.zuche.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtils {
	public static String getLocalIpAddr() {
		String ip = null;
		try {
			// 获得本机ip地址
			String ipAll = InetAddress.getLocalHost().toString();
			ip = ipAll.substring(ipAll.indexOf("/") + 1);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
}
