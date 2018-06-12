package com.zuche.insert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuche.entity.Joins;
import com.zuche.entity.Store;
import com.zuche.mapper.JoinsMapper;
import com.zuche.mapper.StoreMapper;
import com.zuche.random.RandomStore;
import com.zuche.random.RandomUser;
import com.zuche.utils.LocationUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
public class StoreInsert {

	@Autowired
	private StoreMapper storeMapper;
	
	@Test
	public void insertStore() throws Exception {
		for (int i = 0; i < 50; i++) {
			/*StoreUser storeUser = new StoreUser();
			storeUser.setUsername(RandomUser.getUsername((int) (Math.random() * 6 + 8)));
			storeUser.setPassword(RandomUser.getPassword((int) (Math.random() * 6 + 8)));
			storeUser.setStatus((int) (Math.random() * 2 + 1));*/
			
			String[] addressArr = new String[] { "广东省广州市", "113.2", "111.1" };
			addressArr = RandomStore.getGdAddress(); // 注意日配额
			Store store = new Store();
			store.setAddress(addressArr[0] + RandomUser.getRoad());
			store.setLatitude(Float.parseFloat(addressArr[1]));
			store.setLongitude(Float.parseFloat(addressArr[2]));
			String storename = addressArr[0].substring(
					addressArr[0].indexOf("省") + 1,
					addressArr[0].indexOf("市") + 1)
					+ RandomUser.getChineseName() + "门店";
			store.setStorename(storename);
			store.setPhone(RandomUser.getTel());
			store.setDescription(RandomStore.getDescription());
			store.setTraffic(RandomStore.getTraffic());
			store.setStarttime(RandomStore.getStartDate());
			store.setEndtime(RandomStore.getEndDate());
			
			Integer totalComment = RandomStore.getTotalComment();
			Float avgStar = RandomStore.getAvgStar();
			store.setTotalcomment(totalComment);
			store.setAvgstar(avgStar);
			store.setTotalstar((int) (totalComment * avgStar));
			store.setStatus(RandomStore.getStatus());
			store.setStoreUserId(i + 106);
			
			System.out.println(store);
			storeMapper.insert(store);
		}
	}
	
	@Test
	public void test2() throws Exception {
		for (int i=0; i<100; i++) {
			System.out.println(RandomStore.getStartDate() + "-" + RandomStore.getEndDate());
		}
	}
	
	@Test
	public void distance() throws Exception {
		Map<Store, Double> storeDistances = new HashMap<Store, Double>();  // 单位：m
		List<Store> stores = storeMapper.selectByExample(null);
		for (Store store : stores) {
			double distance = LocationUtils.getDistance(24.0416, 116.436, store.getLatitude(), store.getLongitude());
			distance = new BigDecimal(distance).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			storeDistances.put(store, distance);
			System.out.println(store.getStorename() + "距离梅州：" + distance + "m");
		}
	}
	
	@Autowired 
	private JoinsMapper joinsMapper;
	
	@Test
	public void insertJoins() throws Exception {
		for (int i=0; i<10; i++) {
			Joins joins = new Joins();
			joins.setCompany("湛江花圃门店");
			joins.setName("陈晨");
			joins.setPhone("13432825705");
			joins.setEmail("13432825705@163.com");
			joins.setNote("我想加盟");
			joins.setStatus(1);
			joinsMapper.insert(joins);
		}
	}

}
