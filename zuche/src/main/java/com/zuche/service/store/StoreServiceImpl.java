package com.zuche.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.Store;
import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreExample;
import com.zuche.entity.User;
import com.zuche.entity.UserExample;
import com.zuche.entity.StoreExample.Criteria;
import com.zuche.entity.StoreUser;
import com.zuche.mapper.StoreCarMapper;
import com.zuche.mapper.StoreMapper;

/**
 * 门店service实现类
 * @author cbl
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreCarMapper storeCarMapper;
	
	@Autowired
	private StoreMapper storeMapper;

	/**
	 * 保存车辆信息
	 * @param storeCar 车辆信息
	 */
	@Override
	public void saveCar(StoreCar storeCar) {
		storeCarMapper.insert(storeCar);  // 插入一条记录
	}

	@Override
	public List<Store> findStoreByCondition(String storename, String address,
			String phone, Integer pageNum) {
		// 分页
		PageHelper.startPage(pageNum, 5);
		
		StoreExample storeExample = new StoreExample();
		Criteria criteria = storeExample.createCriteria();
		
		if (storename != null && !storename.trim().equals("")) {
			criteria.andStorenameLike("%" + storename + "%");
		} 
		if (address != null && !address.trim().equals("")) {
			criteria.andAddressLike("%" + address + "%");
		}
		if (phone != null && !phone.trim().equals("")) {
			criteria.andPhoneLike("%" + phone + "%");
		} 
		
		List<Store> existStores = storeMapper.selectByExample(storeExample);
		return existStores;
	}

	/**
	 * 根据字段查询
	 */
	@Override
	public Store findStoreByField(String fieldValue, String fieldName) {
		StoreExample storeExample = new StoreExample();
		Criteria criteria = storeExample.createCriteria();
		
		if (fieldName.equals("storename")) {
			criteria.andStorenameEqualTo(fieldValue);
		} else if (fieldName.equals("phone")) {
			criteria.andPhoneEqualTo(fieldValue);
		} else if (fieldName.equals("id")) {
			criteria.andIdEqualTo(new Integer(fieldValue));
		} else if (fieldName.equals("storeUserId")) {
			criteria.andStoreUserIdEqualTo(new Integer(fieldValue));
		}
		
		List<Store> existStores = storeMapper.selectByExample(storeExample);
		if (existStores != null && existStores.size() > 0)
			return existStores.get(0);
		else
			return null;
	}

	/**
	 * 更新门店
	 */
	@Override
	public void updateStore(Store existStore) {
		storeMapper.updateByPrimaryKey(existStore);
	}

	/**
	 * 保存门店信息
	 */
	@Override
	public void saveStoreInfo(Store store) {
		storeMapper.insert(store);
	}

	/**
	 * 更新门店信息
	 */
	@Override
	public void updateStoreInfo(Store store) {
		storeMapper.updateByPrimaryKey(store);
	}

}
