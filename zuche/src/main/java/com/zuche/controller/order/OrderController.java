package com.zuche.controller.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuche.entity.Orders;
import com.zuche.service.order.OrdersService;
import com.zuche.service.user.UserService;
import com.zuche.utils.CookieUtils;
import com.zuche.utils.PaymentUtil;
import com.zuche.utils.UUIDUtils;

/**
 * 
 * 订单Controller类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrdersService ordersService;
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	public String toPage(@PathVariable String page, Model model) throws Exception {
		
		String result = null;
		
		switch (page) {
		/*case "Reserve":
			List<UserCar> cars = userService.selectCars();
			if (cars != null)
				model.addAttribute("car", cars.get(0));
			result = "order/reserve";
			break;*/
		default:
			result = "errorPage";
			break;
		}
		
		return result;
	}
	
	@RequestMapping("/generateOrder")
	public String generateOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 生成订单
		String storeCarId = request.getParameter("storeCarId");
		String price = request.getParameter("price");
		String insurance = request.getParameter("insurance");
		String nodeductibles = request.getParameter("nodeductibles");
		String totalmoney = request.getParameter("totalmoney");
		String gettime = (String) request.getSession().getAttribute("getDate");
		String returntime = (String) request.getSession().getAttribute("returnDate");
		Orders orders = new Orders();
		orders.setStoreCarId(new Integer(storeCarId));
		orders.setPrice(new Float(price));
		orders.setInsurance(new Float(insurance));
		orders.setNodeductibles(new Float(nodeductibles));
		orders.setTotalmoney(new Float(totalmoney));
		orders.setGettime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(gettime));
		orders.setReturntime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(returntime));
		orders.setTime(new Date());
		orders.setId(UUIDUtils.getUUID());
		orders.setStatus(1);  // 未付款
		// 保存订单
		ordersService.saveOrders(orders);
		// 支付
		request.getSession().setAttribute("orderId", orders.getId());
		return "redirect:/order/pay";
	}
	
	/**
	 * 用户确认支付
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	
	@RequestMapping(value="/pay")
	public String pay(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {
			String domain = CookieUtils.getDomainName(request);
			System.out.println(domain);
			System.out.println("http://" + domain + ":8081/zuche/order/backpay");
			String 	p0_Cmd="Buy",
					p1_MerId="10001126856",  //商家编号  商户易宝支付唯一身份标识
					p2_Order=(String) session.getAttribute("orderId"),
					p3_Amt="0.01",
					p4_Cur="CNY",
					p5_Pid="",
					p6_Pcat="",
					p7_Pdesc="",
					p8_Url="http://" + domain + ":8081/zuche/order/backpay",
					p9_SAF="",
					pa_MP="",
					pd_FrpId="CCB-NET-B2C", //支付通道编码
					pr_NeedResponse="1";
			String keyValue="69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
			String hmac=PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
			String url="https://www.yeepay.com/app-merchant-proxy/node?"+
			"&p0_Cmd="+p0_Cmd+
			"&p1_MerId="+p1_MerId+
			"&p2_Order="+p2_Order+
			"&p3_Amt="+p3_Amt+
			"&p4_Cur="+p4_Cur+
			"&p5_Pid="+p5_Pid+
			"&p6_Pcat="+p6_Pcat+
			"&p7_Pdesc="+p7_Pdesc+
			"&p8_Url="+p8_Url+
			"&p9_SAF="+p9_SAF+
			"&pa_MP="+pa_MP+
			"&pd_FrpId="+pd_FrpId+
			"&pr_NeedResponse="+pr_NeedResponse+
			"&hmac="+hmac;
			//response.sendRedirect(url);
			return "redirect:"+url;
	}
	/**
	 * 
	 * 获取支付后的参数
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/backpay")
	public String backPay(HttpServletRequest request,HttpSession session, Model model) throws Exception{
		System.out.println("我收到支付信息");
		String r1_Code=request.getParameter("r1_Code");
		String result="";
		if("1".equals(r1_Code)) //如果支付成功
		{
			String p1_MerId=request.getParameter("p1_MerId");
			String r3_Amt=request.getParameter("r3_Amt");
			String r6_Order=request.getParameter("r6_Order");
			String rp_PayDate=request.getParameter("rp_PayDate");
			String  r2_TrxId=request.getParameter("r2_TrxId");
			result=""
					+ "商户编号"+p1_MerId+"<br/>"
					+ "֧支付金额"+r3_Amt+"<br/>"
					+"商户订单号"+r6_Order+"<br/>"
					+"֧支付成功时间"+rp_PayDate+"<br/>"+"交易流水号"+ r2_TrxId;
			// 设置订单状态为2
			List<Orders> orderss = ordersService.findOrdersByField((String) session.getAttribute("orderId"), "id");
			if (orderss != null && orderss.size() > 0) {
				Orders orders = orderss.get(0);
				orders.setStatus(2);  // 订单状态：已经支付
				ordersService.updateOrders(orders);  // 更新订单
			}
			// 设置信息
			model.addAttribute("resultCode", 1);  // 1为成功，2为失败
			model.addAttribute("resultText", "支付成功！"); // 显示结果
			model.addAttribute("redirectText", "首页");  // 跳转到首页
			model.addAttribute("redirectUrl", "toIndex");  // 跳转链接
			return "common/result";
		}
		else
		{
			// 设置信息
			model.addAttribute("resultCode", 2);  // 1为成功，2为失败
			model.addAttribute("resultText", "支付失败，请前往个人中心重新支付！"); // 显示结果
			model.addAttribute("redirectText", "首页");  // 跳转到首页
			model.addAttribute("redirectUrl", "toIndex");  // 跳转链接
			return "common/result";
		}
	}
}
