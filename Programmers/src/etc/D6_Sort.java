package etc;

import java.util.*;

public class D6_Sort { // ���� ����
	
	public static void main(String[] args) {
		
		D6_Sort d = new D6_Sort();
		
		int[] arr = new int[1000];
		Random rd = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(99)+1;
		}
		
		d.selectionSort(arr);
		d.insertionSort(arr);
		d.bubbleSort(arr);
		d.quickSort(arr);
		d.mergeSort(arr);
	}
	
	// ���� ���� => O(N^2)
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
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		
		System.out.println();
		System.out.println("selectionSort : " + secDiffTime);
	}
	
	// ���� ���� => O(N^2)
	// �̹� ���ĵ� ���¿����� O(N)���� ����
	public void insertionSort(int[] arr) {
		
		int[] result = Arrays.copyOf(arr, arr.length);
		long beforeTime = System.currentTimeMillis();
		
		for(int i = 1; i < result.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(result[j+1] < result[j]) {
					int tmp = result[j+1];
					result[j+1] = result[j];
					result[j] = tmp;
				}else {
					break;
				}
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		
		System.out.println();
		System.out.println("insertionSort : " + secDiffTime);
	}
	
	// ���� ���� => O(N^2)
	public void bubbleSort(int[] arr) {
		
		int[] result = Arrays.copyOf(arr, arr.length);
		long beforeTime = System.currentTimeMillis();
		
		for(int i = 0; i < result.length-1; i++) {
			for(int j = 0; j < result.length-i-1; j++) {
				if(result[j+1] < result[j]) {
					int tmp = result[j+1];
					result[j+1] = result[j];
					result[j] = tmp;
				}
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		
		System.out.println();
		System.out.println("bubbleSort : " + secDiffTime);
	}
	
	// �� ���� => O(NlogN)
	// �߰� �޸𸮰� �ʿ����� �ʴ�.
	// ���ĵ� ��� ������ ����ð��� �����
	public void quickSort(int[] arr) {
		
		int[] result = Arrays.copyOf(arr, arr.length);
		long beforeTime = System.currentTimeMillis();
		
		qs(result, 0, result.length-1);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		
		System.out.println();
		System.out.println("quickSort : " + secDiffTime);
	}
	
	private void qs(int[] result, int start, int end) {
		
		if(start >= end) return;
		
		int pivot = start;
		int left = start+1;
		int right = end;
		
		while(left <= right) {
			
			// �ǹ����� ���� ������ left ����
			while(left <= end && result[left] <= result[pivot]) {
				left++;
			}
			
			// �ǹ����� ���� ũ�� right ����
			while(right > start && result[right] >= result[pivot]) {
				right--;
			}
			
			// left�� right�� �����ϸ� �ǹ��� ���� ���� right ��ü
			if(left > right) {
				int tmp = result[pivot];
				result[pivot] = result[right];
				result[right] = tmp;
			}else {
				int tmp = result[left];
				result[left] = result[right];
				result[right] = tmp;
			}
		}
		
		// divide
		qs(result, start, right-1);
		qs(result, right+1, end);
	}
	
	// �պ� ���� => O(NlogN)
	// LinkedList�� ����ϸ� �ӽ� �迭�� �ʿ����� �����Ƿ� �� ȿ����
	// ������ ������ �� ���� �޾� �������� ���
	public void mergeSort(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length);
		int[] tmp = new int[arr.length];
		long beforeTime = System.currentTimeMillis();
		
		ms(tmp, result, 0, arr.length-1);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		
		System.out.println();
		System.out.println("mergeSort : " + secDiffTime);
	}
	
	private void ms(int[] tmp, int[] result, int left, int right){
		int mid;
		
		if(left < right) {
			mid = (left + right)/2;
			ms(tmp, result, left, mid);
			ms(tmp, result, mid+1, right);
			merge(tmp, result, left, right, mid);
		}
	}
	
	private void merge(int[] tmp, int[] result, int left, int right, int mid) {
		
		int i = left;
		int j = mid+1;
		int k = left;
		
		while(i <= mid && j <= right) {
			if(result[i] <= result[j]) {
				tmp[k++] = result[i++];
			}else {
				tmp[k++] = result[j++];
			}
		}
		
		if(i > mid) {
			for(int l = j; l <= right; l++) {
				tmp[k++] = result[l];
			}
		}else {
			for(int l = i; l <= mid; l++) {
				tmp[k++] = result[l];
			}
		}
		
		for(int l = left; l <= right; l++) {
			result[l] = tmp[l];
		}
	}
}
