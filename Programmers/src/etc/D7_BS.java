package etc;

public class D7_BS {

	public static void main(String[] args) {
		
		D7_BS d = new D7_BS();
		
		int[] arr = new int[1000];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		System.out.println(d.BS_recursion(arr, 0, 0, arr.length-1));
		System.out.println(d.BS_for(arr, 100, 0, arr.length-1));
	}
	
	public int BS_recursion(int[] arr, int target, int start, int end) {
		
		int mid;
		
		if(start <= end) {
			mid = (start+end)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				return BS_recursion(arr, target, mid+1, end);
			}else {
				return BS_recursion(arr, target, start, mid-1);
			}
		}
		
		return -1; // Å½»ö ½ÇÆÐ
	}
	
	public int BS_for(int[] arr, int target, int start, int end) {
		
		int mid;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return -1; // Å½»ö ½ÇÆÐ
	}
}
