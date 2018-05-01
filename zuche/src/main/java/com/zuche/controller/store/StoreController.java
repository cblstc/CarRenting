package com.zuche.controller.store;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zuche.entity.StoreCar;
import com.zuche.intercepter.Token;
import com.zuche.service.store.StoreService;
import com.zuche.utils.UUIDUtils;

/**
 * 门店控制类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	@Token(save=true)
	public String toPage(@PathVariable String page, Model model) throws Exception {
		
		String result = null;
		
		switch (page) {
		case "AddCar":  /* 添加车辆 */
			result = "store/article-add";
			break;
		default:  /* 错误页面 */
			result = "errorPage";
			break;
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/uploads", method=RequestMethod.POST)
	public void uploads(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) throws Exception {
		if (file != null) {
			String fileName = saveImage(request, file.getInputStream()); // 保存图片
		}
	}
	
	/**
	 * 保存图片到上传路径的方法
	 * @param request
	 * @param in 图片输入流
	 * @throws Exception
	 * @return 返回文件名
	 */
	public String saveImage(HttpServletRequest request, InputStream in) throws Exception {
		String fileName = UUIDUtils.getUUID() + ".jpg";  // 随机文件名
		String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/uploads") + "/"; // 获得保存路径
		File f = new File(savePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(savePath + fileName);
		int b = 0;
		while ((b = in.read()) != -1) {
			fos.write(b);
		}
		fos.close();
		in.close();
		System.out.println(fileName);
		return fileName;
	}
	
	@RequestMapping(value="/saveCar", method=RequestMethod.POST)
	public String saveCar(StoreCar storeCar) throws Exception {
		if (storeCar != null) {
			if (storeCar.getConfiguration() == "0") {  // 如果车辆配置为"0"，说明用户未选择配置，或该车型下没有配置可选
				storeCar.setConfiguration("");
			} else {  // 根据车辆配置可以知道车辆的出厂年份，如2016款 Sportback
				String year = storeCar.getConfiguration().substring(0, 4);
				/*storeCar.setYear(new SimpleDateFormat("yyyy").parse(year));  // 设置出厂年份
*/			}
			storeCar.setStoreId(1);  // 设置门店id
			storeCar.setStatus(1);   // 设置上架
			storeService.saveCar(storeCar);  // 保存车辆信息
		}
		
		return null;
	}
}
