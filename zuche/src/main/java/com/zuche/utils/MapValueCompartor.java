package com.zuche.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import com.zuche.entity.Store;

public class MapValueCompartor implements Comparator<Map.Entry<Store, Double>> {

	@Override
	public int compare(Entry<Store, Double> o1, Entry<Store, Double> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

}
