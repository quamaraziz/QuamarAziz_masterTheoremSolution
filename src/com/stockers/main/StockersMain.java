package com.stockers.main;

import java.util.Scanner;

import com.stockers.service.PriceDeviation;
import com.stockers.service.Search;
import com.stockers.service.Sort;

public class StockersMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double  stockPrice[];
		boolean stockPriceResponse[];
		int userResponse;
		double key;
		
		System.out.println("Enter the number of companies :");
		int companyCount = sc.nextInt();
		stockPrice = new double[companyCount];
		stockPriceResponse = new boolean[companyCount];
		
		for(int  i = 0; i <companyCount; i++) {
			System.out.println("Enter current stock price of the company "+(i+1));
			stockPrice[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			stockPriceResponse[i] = sc.nextBoolean();
		}
		double arr[] = Sort.sort(stockPrice, 0, stockPrice.length -1);
				
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("-----------------------------------------------");
			userResponse = sc.nextInt();
			
			switch(userResponse){
			case 0:
				System.out.println("Exited successfully");
				break;
			case 1:
				System.out.println("Stock prices in ascending order are :");
				for(int i= 0; i<arr.length; i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				break;
			case 2:
				System.out.println("Stock prices in descending order are :");
				for(int i= arr.length-1; i>=0; i--) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				break;
			case 3:
				System.out.println("Total no of companies whose stock price rose today : "+PriceDeviation.priceRise(stockPriceResponse));
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today : "+PriceDeviation.priceDip(stockPriceResponse));
				break;
			case 5:
				System.out.println("Enter the key value :");
				key = sc.nextDouble();
//				Search.searchKey(stockPrice, key);
				if(Search.searchKey(stockPrice, key))
					System.out.println("Stock of value "+key+" is present");
				else
					System.out.println("Value not found");
				break;
			case 6:
				System.out.println("press 0 to exit");
				break;
			default:
				System.out.println("Invalid input ! choose from the given list");
			
			}
		}while(userResponse !=0);
		sc.close();
	}

}
