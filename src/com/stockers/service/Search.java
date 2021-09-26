package com.stockers.service;

public class Search {
	public static boolean searchKey(double arr[], double key) {
		int left = 0;
		int right = arr.length - 1;
				
		while(left<=right) {
			int mid = (left + right)/2;
			
			if(arr[mid]==key) {
				return true;
			}
			else if(arr[mid] < key) {
				left = mid + 1;
			}
			else{
				right = mid-1;
			
			}
		}
		return false;
		
	}

}
