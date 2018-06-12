package com.zuche.service.customer;

import java.util.List;

import com.zuche.entity.Joins;

/**
 * 加盟服务接口
 * @author cbl
 *
 */
public interface JoinsService {

	/**
	 * 保存加盟类对象
	 * @param joins 
	 */
	void saveJoins(Joins joins);

	/**
	 * 条件查询操作
	 * @param name
	 * @param phone
	 * @param status
	 * @param pageNum
	 * @return
	 */
	List<Joins> findJoinsByCondition(String name, String phone, Integer status,
			Integer pageNum);

	/**
	 * 根据字段查找
	 * @param fieldValue
	 * @param fieldName
	 * @return
	 */
	Joins findJoinsByField(String fieldValue, String fieldName);

	/**
	 * 更新加盟对象
	 * @param existJoins
	 */
	void updateJoins(Joins existJoins);

	/**
	 * 发送账号给申请人
	 * @param username
	 * @param password
	 * @param email
	 */
	void sendAccount(String username, String password, String email);

	/**
	 * 如果已经存在账号，那么通知申请人账号可以使用
	 * @param email
	 */
	void sendPass(String email);

	/**
	 * 拒绝加盟信
	 * @param email
	 */
	void sendFail(String email);
}
