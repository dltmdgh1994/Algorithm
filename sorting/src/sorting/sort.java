package sorting;

import java.util.Vector;

class sort {
	// <T extends Comparable<T>> : ���ڽŰ� �񱳵� �� �ִ� ��� Ÿ�� T��
	public <T extends Comparable<T>> void selectionSort(T t[], int method) {
		int idx;
		T tmp;
		if( t.length <= 0) {
			return;
		}
		
		if(method == 0) { //��������
			for(int i = 0; i < t.length-1; i++) {
				idx = i; 
				for(int j = i+1; j < t.length; j++) {
					// compareTo => 1 : ũ��, 0 : ����, -1 : �۴�
					if(t[idx].compareTo(t[j]) > 0) {
						idx = j;
					}
				}
				tmp = t[i];
				t[i] = t[idx];
				t[idx] = tmp;
			}
		}
		else if(method == 1) { //��������
			for(int i = 0; i < t.length-1; i++) {
				idx = i; 
				for(int j = i+1; j < t.length; j++) {
					// compareTo => 1 : ũ��, 0 : ����, -1 : �۴�
					if(t[idx].compareTo(t[j]) < 0) {
						idx = j;
					}
				}
				tmp = t[i];
				t[i] = t[idx];
				t[idx] = tmp;
			}
		}
		else {
			System.out.println("Set method Param 0 or 1");
		}
	}
	
	
	public <T extends Comparable<T>> void insertionSort(T t[], int method) {
		int idx;
		T tmp;
		
		if( t.length <= 0) {
			return;
		}
		
		if(method == 0) { //��������
			for(int i = 1; i < t.length; i++) {
				tmp = t[i];
				idx = i;
				for(int j = i - 1; j >= 0; j--) {
					if(tmp.compareTo(t[j]) < 0) {
						t[j+1] = t[j];
						idx = j;
					}
				}
				t[idx] = tmp;
			}
		}
		else if(method == 1) { //��������
			for(int i = 1; i < t.length; i++) {
				tmp = t[i];
				idx = i;
				for(int j = i - 1; j >= 0; j--) {
					if(tmp.compareTo(t[j]) > 0) {
						t[j+1] = t[j];
						idx = j;
					}
				}
				t[idx] = tmp;
			}
		}
		else {
			System.out.println("Set method Param 0 or 1");
		}
	}
	
	
	public <T extends Comparable<T>> void bubbleSort(T t[], int method) {
		T tmp;
		
		if( t.length <= 0) {
			return;
		}
		
		if(method == 0) { //��������
			for(int i = 1; i < t.length ; i++) {
				for(int j = 0; j < t.length - i; j++) {
					if(t[j].compareTo(t[j+1]) > 0) {
						tmp = t[j+1];
						t[j+1] = t[j];
						t[j] = tmp;
					}
				}
			}
		}
		else if(method == 1) { //��������
			for(int i = 1; i < t.length ; i++) {
				for(int j = 0; j < t.length - i; j++) {
					if(t[j].compareTo(t[j+1]) < 0) {
						tmp = t[j+1];
						t[j+1] = t[j];
						t[j] = tmp;
					}
				}
			}
		}
		else {
			System.out.println("Set method Param 0 or 1");
		}
	}
	
	
	public <T extends Comparable<T>> void mergeSort(T t[], int s, int e, int method) {
		int mid = (s+e)/2;
		
		if( t.length <= 0) {
			return;
		}
		
		if(s < e) {
			mergeSort(t, s, mid, method);
			mergeSort(t, mid+1, e, method);
			
			merge(t, s, e, mid, method);
		}
		else if(s >= e) {}
		else {
			System.out.println("Set method Param 0 or 1");
		}
	}
	
	private <T extends Comparable<T>> void merge(T t[], int s, int e, int m, int method) {
		Vector<T> v = new Vector<>();
		int i = s; int j = m+1;
		
		if(method == 0) { //��������
			
			//����� ������ ���Ϳ� �ϳ��� ���Ͽ� ����
			while(i <= m && j <= e) {
				if(t[i].compareTo(t[j]) < 0) {
					v.add(t[i++]);
				}else {
					v.add(t[j++]);
				}
			}
			
			//���� ���� ä�� �ֱ�
			while(i <= m) {
				v.add(t[i++]);
			}
			while(j <= e) {
				v.add(t[j++]);
			}
			
			//���� �迭�� ����
			int idx = 0;
			for(int k = s; k <= e; k++) {
				t[k] = v.get(idx++);
			}
		}
		else { //��������
			
			//����� ������ ���Ϳ� �ϳ��� ���Ͽ� ����
			while(i <= m && j <= e) {
				if(t[i].compareTo(t[j]) > 0) {
					v.add(t[i++]);
				}else {
					v.add(t[j++]);
				}
			}
			
			//���� ���� ä�� �ֱ�
			while(i <= m) {
				v.add(t[i++]);
			}
			while(j <= e) {
				v.add(t[j++]);
			}
			
			//���� �迭�� ����
			int idx = 0;
			for(int k = s; k <= e; k++) {
				t[k] = v.get(idx++);
			}
		}
	}
	
	
	public <T extends Comparable<T>> void quickSort(T t[], int s, int e, int method) {
		// Pivot�� ���� �� ��, �� ��, �߰� �߿� ����.
		T p = t[s];
		int i = s; int j = e;
		
		if( t.length <= 0) {
			return;
		}
		
		if(method == 0) { //��������
			//Ž���� �ϸ� �ٲ۴�.
			while(i < j) {
				while(p.compareTo(t[j]) <= 0 && i < j) { j--; }
				while(p.compareTo(t[i]) >= 0 && i < j) { i++; }
				T tmp = t[i];
				t[i] = t[j];
				t[j] = tmp;
			}
			//Pivot�� Ž���� ��ģ ������ �ٲ۴�.
			T tmp = t[s];
			t[s] = t[i];
			t[i] = tmp;
			
			if(s < i) {
				quickSort(t, s, i-1, method);
			}
			if(e > j) {
				quickSort(t, i+1, e, method);
			}
		}
		else if(method == 1) { //��������
			while(i < j) {
				while(p.compareTo(t[j]) >= 0 && i < j) { j--; }
				while(p.compareTo(t[i]) <= 0 && i < j) { i++; }
				T tmp = t[i];
				t[i] = t[j];
				t[j] = tmp;
			}
			T tmp = t[s];
			t[s] = t[i];
			t[i] = tmp;
			
			if(s < i) {
				quickSort(t, s, i-1, method);
			}
			if(e > j) {
				quickSort(t, i+1, e, method);
			}
		}
		else {
			System.out.println("Set method Param 0 or 1");
		}
	}
	
	//����������
	public int[] countingSort(int t[]) {
		
		if( t.length <= 0) {
			return t;
		}
		
		//�ִ� ã��
		int max = t[0];
		for(int i = 1; i < t.length; i++) {
			if(max < t[i]) {
				max = t[i];
			}
		}
		
		int cnt[] = new int[max+1];
		for(int i = 0; i < t.length; i++) {
			cnt[t[i]]++;
		}
		
		for(int i =1; i < cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		
		int result[] = new int[t.length];
		for(int i = t.length-1; i >=0; i--) {
			result[ --cnt[t[i]] ] = t[i];  
		}
		
		return result;
	}
}
