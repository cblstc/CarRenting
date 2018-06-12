package com.zuche.service.store;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.Store;
import com.zuche.entity.StoreDistance;
import com.zuche.entity.StoreExample;
import com.zuche.entity.StoreExample.Criteria;
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

	@Override
	public List<Store> findStoresByCondition(Map<String, String> conds) {
		StoreExample storeExample = new StoreExample();
		Criteria criteria = storeExample.createCriteria();
		
		if (conds != null) {
			for (String fieldName : conds.keySet()) {  // 遍历字段名
				String fieldValue = conds.get(fieldName);  // 获得字段对应的值
				if (fieldName != null) {
					if (fieldName.equals("storename")) {
						criteria.andStorenameEqualTo(fieldValue);
					}
					if (fieldName.equals("phone")) {
						criteria.andPhoneEqualTo(fieldValue);
					} 
					if (fieldName.equals("id")) {
						criteria.andIdEqualTo(new Integer(fieldValue));
					} 
					if (fieldName.equals("storeUserId")) {
						criteria.andStoreUserIdEqualTo(new Integer(fieldValue));
					}
				}
			}
		}
		
		List<Store> existStores = storeMapper.selectByExample(storeExample);
		return existStores;
	}

	@Override
	public List<StoreDistance> findNearbyStore(Double latitude, Double longitude,
			int count) {
		List<StoreDistance> storeDistances = storeMapper.findNearbyStore(latitude, longitude, count);
		return storeDistances;
	}

}
