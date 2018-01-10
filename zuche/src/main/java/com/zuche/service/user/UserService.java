package com.zuche.service.user;

import java.util.List;

import com.zuche.entity.User;
import com.zuche.entity.UserCar;
import com.zuche.entity.UserInfo;

/**
 * 用户Service类
 * @author cbl
 *
 */
public interface UserService {

	/**
	 * 保存user
	 * @param user 用户对象
	 */
	void saveUser(User user);

	/**
	 * 保存userinfo
	 * @param userInfo 用户信息
	 * @param user 用户对象
	 */
	void saveInfo(UserInfo userInfo, User user);

	/**
	 * 根据用户id查询用户信息
	 * @param uid 用户id
	 * @return
	 */
	UserInfo selectInfoByUid(Integer uid);

	/**
	 * 登录判断
	 * @param user 用户
	 * @return
	 */
	User findUser(User user);

	/**
	 * 保存我的车辆
	 * @param userCar 用户车辆
	 * @param user
	 * @param method
	 */
	void saveCar(UserCar userCar, User user, String method);

	/**
	 * 查询所有车辆
	 * @return
	 */
	List<UserCar> selectCars();

	/**
	 * 根据电话查询用户
	 * @param phone 电话
	 * @return
	 */
	User findUserByPhone(String phone);
}
