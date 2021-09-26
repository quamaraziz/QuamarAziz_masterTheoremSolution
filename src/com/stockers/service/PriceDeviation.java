package com.stockers.service;

public class PriceDeviation {
	
	public static int priceRise(boolean arr[]) {
		int counter =0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==true) {
				counter++;
			}
		}
		return counter;
	}
	
	public static int priceDip(boolean arr[]) {
		int counter = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=true) {
				counter++;
			}
		}
		return counter++;
	}
}
