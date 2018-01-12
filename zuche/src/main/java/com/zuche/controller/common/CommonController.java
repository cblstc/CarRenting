package com.zuche.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuche.intercepter.Token;

/**
 * 通用控制类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	/**
	 * 页面跳转
	 * @param page 需要跳转的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/to{page}")
	public String toPage(@PathVariable String page, Model model) {
		if (page.equals("Result")) {
			return "common/result";
		} else if (page.equals("RepeatCommit")) {
			return "common/repeatCommit";
		} else {
			return "errorPage";
		}
	}
}
