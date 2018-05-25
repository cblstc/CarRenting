package com.zuche.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.AdminUser;
import com.zuche.entity.AdminUserExample;
import com.zuche.entity.AdminUserExample.Criteria;
import com.zuche.mapper.AdminUserMapper;
import com.zuche.utils.MD5Utils;

/**
 * 管理员用户service实现类
 * @author cbl
 *
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired
	private AdminUserMapper adminUserMapper;

	/**
	 * 登录判断
	 */
	@Override
	public AdminUser findAdminUser(AdminUser adminUser) {
		AdminUserExample adminUserExample = new AdminUserExample();
		Criteria criteria = adminUserExample.createCriteria();
		// 校验用户名
		criteria.andUsernameEqualTo(adminUser.getUsername()); 
		// 校验密码
		criteria.andPasswordEqualTo(MD5Utils.getMD5Str(adminUser.getPassword()));
		
		List<AdminUser> existUsers = adminUserMapper.selectByExample(adminUserExample);
		if (existUsers != null && existUsers.size() > 0)
			return existUsers.get(0);
		else
			return null;
	}

}
