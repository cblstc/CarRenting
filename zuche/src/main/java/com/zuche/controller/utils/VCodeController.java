package com.zuche.controller.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zuche.utils.MD5Utils;

/**
 * 短信验证码控制类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/utils")
public class VCodeController {

	/**
	 * 发送验证码
	 * @param response
	 * @param phone 手机号码
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="sendVCode", method=RequestMethod.POST)
	public void sendVCode(HttpServletResponse response, String phone, Model model) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		
		String accountSid = "3cb85fb9338a4024a0db91aed0818eb7";
		String authToken = "ee06936109ad4759bbf527ec9fedcc00";
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		int vCode = 1 + (int)(Math.random() * 999999);
		model.addAttribute("vCode", vCode);
		
		String result = "";
		String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
		StringBuffer body = new StringBuffer();
		body.append("accountSid=" + accountSid);
		body.append("&smsContent=【Cargo租车】您的验证码为" + vCode + "，请于1分钟内正确输入，如非本人操作，请忽略此短信。");
		body.append("&to=" + phone);
		body.append("&timestamp=" + timestamp);
		body.append("&sig=" + MD5Utils.getMD5Str(accountSid + authToken + timestamp));
		body.append("&respDataType=JSON");
		System.out.println(body);
		
		OutputStreamWriter out = null;
		BufferedReader in = null;
		URL realUrl = new URL(url);
		URLConnection conn = realUrl.openConnection();

		// 设置连接参数
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(20000);

		// 提交数据
		out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
		out.write(body.toString());
		out.flush();

		// 读取返回数据
		in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String line = "";
		boolean firstLine = true; // 读第一行不加换行符
		while ((line = in.readLine()) != null)
		{
			if (firstLine)
			{
				firstLine = false;
			} else
			{
				result += System.lineSeparator();
			}
			result += line;
		}
		response.getWriter().print(vCode);
	}
}
