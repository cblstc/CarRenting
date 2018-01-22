package com.zuche.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.UserInfo;
import com.zuche.entity.UserInfoExample;
import com.zuche.entity.UserInfoExample.Criteria;
import com.zuche.mapper.UserInfoMapper;

/**
 * 用户信息service实现类
 * @author cbl
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper infoMapper;

	/**
	 * 保存用户信息
	 */
	@Override
	public void saveUserInfo(UserInfo userInfo) {
		infoMapper.insert(userInfo);
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUserInfo(UserInfo userInfo) {
		infoMapper.updateByPrimaryKey(userInfo);
	}

	/**
	 * 根据字段获取用户信息
	 */
	@Override
	public UserInfo findUserInfoByField(String fieldValue, String fieldName) {
		UserInfoExample infoExample = new UserInfoExample();
		Criteria criteria = infoExample.createCriteria();
		
		if (fieldName.equals("idcard")) {
			criteria.andIdcardEqualTo(fieldValue);
		} else if (fieldName.equals("userId")) {
			criteria.andUserIdEqualTo(new Integer(fieldValue));
		}
		List<UserInfo> userInfos = infoMapper.selectByExample(infoExample);
		
		if (userInfos != null && userInfos.size() > 0) {
			return userInfos.get(0);
		}
		return null;
	}

}
