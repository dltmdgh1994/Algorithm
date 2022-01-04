package etc;

import java.util.*;

public class D6_Sort { // 정렬 정리
	
	public static void main(String[] args) {
		
		D6_Sort d = new D6_Sort();
		
		int[] arr = new int[1000];
		Random rd = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(99)+1;
		}
		
		d.selectionSort(arr);
	}
	
	public void selectionSort(int[] arr) {
		
		int[] result = Arrays.copyOf(arr, arr.length);
		long beforeTime = System.currentTimeMillis();
		
		for(int i = 0; i < result.length-1; i++) {
			int minIdx = i;
			
			for(int j = i+1; j < result.length; j++) {
				if(result[j] < result[minIdx]) {
					minIdx = j;
				}
			}
			
			int tmp = result[i];
			result[i] = result[minIdx];
			result[minIdx] = tmp;
			
			System.out.print(result[i] + " ");
		}
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		
		System.out.println();
		System.out.println("selectionSort : " + secDiffTime);
	}
}
