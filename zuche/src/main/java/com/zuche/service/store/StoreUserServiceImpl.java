package com.zuche.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.StoreUser;
import com.zuche.entity.StoreUserExample;
import com.zuche.entity.User;
import com.zuche.entity.UserExample;
import com.zuche.entity.StoreUserExample.Criteria;
import com.zuche.mapper.StoreUserMapper;
import com.zuche.utils.MD5Utils;

/**
 * 门店账号服务类
 * @author cbl
 *
 */
@Service
public class StoreUserServiceImpl implements StoreUserService {

	@Autowired
	private StoreUserMapper storeUserMapper;
	
	/**
	 * 保存门店账号
	 */
	@Override
	public void saveStoreUser(StoreUser storeUser) {
		storeUser.setStatus(1);  // 可用
		storeUserMapper.insert(storeUser);
	}

	/**
	 * 根据字段查询门店账号
	 */
	@Override
	public StoreUser findUserByField(String fieldValue, String fieldName) {
		StoreUserExample storeUserExample = new StoreUserExample();
		Criteria criteria = storeUserExample.createCriteria();
		
		if (fieldName.equals("username")) {
			criteria.andUsernameEqualTo(fieldValue);
		} else if (fieldName.equals("id")) {
			criteria.andIdEqualTo(new Integer(fieldValue));
		}
		
		List<StoreUser> existUsers = storeUserMapper.selectByExample(storeUserExample);
		if (existUsers != null && existUsers.size() > 0)
			return existUsers.get(0);
		else
			return null;
	}

	/**
	 * 更新门店账号
	 */
	@Override
	public void updateStoreUser(StoreUser existStoreUser) {
		storeUserMapper.updateByPrimaryKey(existStoreUser);
	}

	/**
	 * 登陆判断
	 */
	@Override
	public StoreUser findStoreUser(StoreUser storeUser) {
		StoreUserExample storeUserExample = new StoreUserExample();
		Criteria criteria = storeUserExample.createCriteria();
		// 校验用户名
		criteria.andUsernameEqualTo(storeUser.getUsername()); 
		// 校验密码
		criteria.andPasswordEqualTo(MD5Utils.getMD5Str(storeUser.getPassword()));
		
		List<StoreUser> existUsers = storeUserMapper.selectByExample(storeUserExample);
		if (existUsers != null && existUsers.size() > 0)
			return existUsers.get(0);
		else
			return null;
	}
}
