package kr.or.bit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import kr.or.bit.dto.Sale;

public class Test {
	public static void main(String[] args) {
		ArrayList<Sale> list = new ArrayList<Sale>();
		ArrayList<String> priceList = new ArrayList<String>();
		String stringPrice = null;
		Map<Sale, String> saleMap = new TreeMap<Sale, String>();
		for (Sale sale : list) {
			double num = 79830;
			int price = sale.getPrice();
			double price2 = num / price * 100;
			stringPrice = Double.toString(price2) + "%";
			saleMap.put(sale, stringPrice);
		}
		System.out.println(saleMap.toString());
		System.out.println(saleMap.values());

		List<String> list2 = new ArrayList();

		list.addAll(saleMap.keySet());

		Collections.sort(list, new Comparator() {

			public int compare(Object o1, Object o2) {

				Object v1 = saleMap.get(o1);

				Object v2 = saleMap.get(o2);

				return ((Comparable) v2).compareTo(v1);

			}

		});
	}
}
