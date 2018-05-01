package com.zuche.service.customer;

import java.net.UnknownHostException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.Joins;
import com.zuche.entity.JoinsExample;
import com.zuche.entity.User;
import com.zuche.entity.UserExample;
import com.zuche.entity.JoinsExample.Criteria;
import com.zuche.mapper.JoinsMapper;
import com.zuche.utils.IPUtils;
import com.zuche.utils.MailUtils;

/**
 * 加盟服务类
 * @author cbl
 *
 */
@Service
public class JoinsServiceImpl implements JoinsService {
	
	@Autowired
	private JoinsMapper joinsMapper;

	@Override
	public void saveJoins(Joins joins) {
		joins.setStatus(1); // 1-正在申请 2-申请通过 3-申请不通过
		joinsMapper.insert(joins);
	}

	/**
	 * 条件查询操作
	 */
	@Override
	public List<Joins> findJoinsByCondition(String name, String phone,
			Integer status, Integer pageNum) {
		// 分页
		PageHelper.startPage(pageNum, 5);
		
		JoinsExample joinsExample = new JoinsExample();
		Criteria criteria = joinsExample.createCriteria();
		
		if (name != null && !name.trim().equals("")) {
			criteria.andNameLike("%" + name + "%");
		} 
		if (phone != null && !phone.trim().equals("")) {
			criteria.andPhoneLike("%" + phone + "%");
		} 
		if (status != null) {
			criteria.andStatusEqualTo(status);
		}
		
		List<Joins> existJoinss = joinsMapper.selectByExample(joinsExample);
		return existJoinss;
	}

	/**
	 * 根据字段查找
	 */
	@Override
	public Joins findJoinsByField(String fieldValue, String fieldName) {
		JoinsExample joinsExample = new JoinsExample();
		Criteria criteria = joinsExample.createCriteria();
		
		if (fieldName.equals("name")) {
			criteria.andNameEqualTo(fieldValue);
		} else if (fieldName.equals("phone")) {
			criteria.andPhoneEqualTo(fieldValue);
		} else if (fieldName.equals("company")) {
			criteria.andCompanyEqualTo(fieldValue);
		}  else if (fieldName.equals("email")) {
			criteria.andEmailEqualTo(fieldValue);
		} else if (fieldName.equals("id")) {
			criteria.andIdEqualTo(new Integer(fieldValue));
		}
		
		List<Joins> existJoinss = joinsMapper.selectByExample(joinsExample);
		if (existJoinss != null && existJoinss.size() > 0)
			return existJoinss.get(0);
		else
			return null;
	}

	@Override
	public void updateJoins(Joins existJoins) {
		joinsMapper.updateByPrimaryKey(existJoins);
	}

	@Override
	public void sendAccount(String username, String password, String email) {
		String url = "http://" + IPUtils.getLocalIpAddr() + ":8080/zuche/store/toLogin";
		String content = "您好！经过管理员的审核，认定您符合Cargo租车的入驻条件，您的门店平台账号为：\n" +
				"用户名：" + username + ",密码：" + password + "\n" +
				"请妥善保管，并及时更换密码！门店平台入口：" + url;
		try {
			MailUtils.sendMail("13432825705@163.com", "13432825705", "chenbolong95", 
					email, "Cargo租车加盟申请反馈", content);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 如果已经存在账号，那么通知申请人账号可以使用
	 */
	@Override
	public void sendPass(String email) {
		String url = "http://" + IPUtils.getLocalIpAddr() + ":8080/zuche/store/toLogin";
		String content = "您好！经过管理员的审核，您的平台账号已经重新开启，门店平台入口：" + url;
		try {
			MailUtils.sendMail("13432825705@163.com", "13432825705", "chenbolong95", 
					email, "Cargo租车加盟申请反馈", content);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendFail(String email) {
		String content = "很抱歉，经过管理员的审核，认定您不符合Cargo租车的入驻条件。	";
		try {
			MailUtils.sendMail("13432825705@163.com", "13432825705", "chenbolong95", 
					email, "Cargo租车加盟申请反馈", content);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
