package com.zuche.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.User;
import com.zuche.entity.UserCar;
import com.zuche.entity.UserExample;
import com.zuche.entity.UserExample.Criteria;
import com.zuche.entity.UserInfo;
import com.zuche.entity.UserInfoExample;
import com.zuche.mapper.UserCarMapper;
import com.zuche.mapper.UserInfoMapper;
import com.zuche.mapper.UserMapper;

/**
 * 用户Service实现类
 * @author cbl
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper infoMapper;
	
	@Autowired
	private UserCarMapper carMapper;

	/**
	 * 保存用户
	 */
	public void saveUser(User user) {
		user.setStatus(1);  // 设置可用
		userMapper.insert(user);
	}

	/**
	 * 完善用户信息
	 */
	public void saveInfo(UserInfo userInfo, User user) {
		userInfo.setUserId(user.getId());  // 指定用户id
		UserInfo existInfo = this.selectInfoByUid(user.getId());
		
		if (existInfo != null) {
			// 如果存在用户信息，那么直接修改
			userInfo.setId(existInfo.getId());
			infoMapper.updateByPrimaryKey(userInfo);
		}
		else
			// 否则，直接插入
			infoMapper.insert(userInfo);
	}

	/**
	 * 根据用户id查询用户信息
	 */
	public UserInfo selectInfoByUid(Integer uid) {
		UserInfoExample infoExample = new UserInfoExample();
		infoExample.createCriteria().andUserIdEqualTo(uid);
		List<UserInfo> existInfos = infoMapper.selectByExample(infoExample);
		if (existInfos != null && existInfos.size() > 0)
			return existInfos.get(0);
		return null;
	}

	/**
	 * 登录判断
	 */
	public User findUser(User user) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		
		if (user.getPhone() != null && !user.getPhone().trim().equals(""))
			criteria.andPhoneEqualTo(user.getPhone()); // 校验电话
		else if (user.getUsername() != null && !user.getUsername().trim().equals(""))
			criteria.andUsernameEqualTo(user.getUsername()); // 校验用户名
		else if (user.getEmail() != null && !user.getEmail().trim().equals(""))
			criteria.andEmailEqualTo(user.getEmail()); // 校验邮箱
		
		// 校验密码
		criteria.andPasswordEqualTo(user.getPassword());
		
		List<User> existUsers = userMapper.selectByExample(userExample);
		if (existUsers != null && existUsers.size() > 0)
			return existUsers.get(0);
		else 
			return null;
	}

	/**
	 * 保存我的车辆
	 */
	public void saveCar(UserCar userCar, User user, String method) {
		userCar.setUserId(user.getId());  // 指定用户id
		if (method.equals("add")) {
			userCar.setSales(0);  // 下单数
			userCar.setOrdertakingcount(0);  // 接单数
			userCar.setOrdertakingrate(0.0f);  // 接单率

			userCar.setTotalcomment(0);  // 总评论数
			userCar.setTotalstar(0);  // 总星数
			userCar.setAvgstar(0.0f);  // 平均星数
			userCar.setStatus(1);  // 待审核
			carMapper.insert(userCar);
		}
		else if (method.equals("edit")) {
			carMapper.updateByPrimaryKey(userCar);
		}
	}

	/**
	 * 查询所有车辆
	 */
	@Override
	public List<UserCar> selectCars() {
		return carMapper.selectByExample(null);
	}

	/**
	 * 根据电话查询用户
	 */
	@Override
	public User findUserByPhone(String phone) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andPhoneEqualTo(phone);
		List<User> existUsers = userMapper.selectByExample(userExample);
		if (existUsers != null && existUsers.size() > 0)
			return existUsers.get(0);
		else 
			return null;
	}

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public User findUserByUsername(String username) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		List<User> existUsers = userMapper.selectByExample(userExample);
		if (existUsers != null && existUsers.size() > 0)
			return existUsers.get(0);
		else 
			return null;
	}
	
}
