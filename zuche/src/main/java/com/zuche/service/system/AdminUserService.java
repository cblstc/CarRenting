package com.zuche.service.system;

import com.zuche.entity.AdminUser;

/**
 * 管理员账号service接口
 * @author cbl
 *
 */
public interface AdminUserService {

	/**
	 * 登录判断
	 * @param adminUser
	 * @return
	 */
	AdminUser findAdminUser(AdminUser adminUser);

}
