package com.stockers.service;

public class Sort {
	public static double[] sort(double arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
		return arr;
	}

	public static void merge(double arr[], int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		double leftArr[] = new double[n1];
		double rightArr[] = new double[n2];

		for (int i = 0; i < n1; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int i = 0; i < n2; i++) {
			rightArr[i] = arr[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftArr[i] < rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;

		}
		while (i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
}
