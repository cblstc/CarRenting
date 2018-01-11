package com.zuche.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuche.entity.User;
import com.zuche.entity.UserCar;

/**
 * 系统管理controller
 * @author cbl
 *
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	
	/*@Autowired
	private BrandService brandService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ConfigurationService configurationService;
	
	
	*//**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("/to{page}")
	public String toPage(@PathVariable String page, Model model) throws Exception {
		String result = null;
		
		switch (page) {
		case "Index":
			result = "system/index";
			break;
		case "AddBrand":
			model.addAttribute("method", "add");
			result = "system/saveBrand";
			break;
		case "EditBrand":
			model.addAttribute("method", "edit");
			result = "system/saveBrand";
			break;
		case "AddModel":
			model.addAttribute("brands", brandService.selectBrands());
			model.addAttribute("method", "add");
			result = "system/saveModel";
			break;
		case "EditModel":
			model.addAttribute("brands", brandService.selectBrands());
			model.addAttribute("method", "edit");
			result = "system/saveModel";
			break;
		case "AddConfiguration":
			model.addAttribute("models", modelService.selectModels());
			model.addAttribute("method", "add");
			result = "system/saveConfiguration";
			break;
		case "EditConfiguration":
			model.addAttribute("models", modelService.selectModels());
			model.addAttribute("method", "edit");
			result = "system/saveConfiguration";
			break;
		default:
			result = "errorPage";
			break;
		}
		
		return result;
	}
	
	@RequestMapping("/saveBrand/{method}")
	public String saveBrand(@PathVariable String method, Brand brand, HttpServletRequest request, Model model) throws Exception {
		// 保存品牌
		brandService.saveBrand(brand, method);
		return "forward:/user/toIndex";
	}
	
	@RequestMapping("/saveModel/{method}")
	public String saveModel(@PathVariable String method, com.zuche.entity.Model carModel, HttpServletRequest request, Model model) throws Exception {
		// 保存品牌
		modelService.saveModel(carModel, method);
		return "forward:/user/toIndex";
	}
	
	@RequestMapping("/saveConfiguration/{method}")
	public String saveConfiguration(@PathVariable String method, Configuration configuration, HttpServletRequest request, Model model) throws Exception {
		// 保存品牌
		configurationService.saveConfiguration(configuration, method);
		return "forward:/user/toIndex";
	}*/
}
