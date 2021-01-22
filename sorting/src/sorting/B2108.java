package sorting;

import java.io.*;
import java.util.ArrayList;

class B2108 {
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			Integer arr[] = new Integer[n];
			Integer a; int sum = 0;
			for(int i = 0; i < n; i++) {
				a = Integer.parseInt(br.readLine());
				sum += a;
				arr[i] =  a;
			}
			
			sort s = new sort();
			s.mergeSort(arr, 0, n-1, 0);
			
			//첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
			bw.write(Integer.toString((int)Math.round((double)sum / n)));
			bw.newLine();

			//둘째 줄에는 중앙값을 출력한다.
			bw.write(Integer.toString(arr[((n+1)/2) -1]));
			bw.newLine();
			
			//셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
			ArrayList<Integer> arraylist = new ArrayList<>();
			int maxCnt = 1; int cnt = 1;
			arraylist.add(arr[0]);
			for(int i = 1; i < n; i++) {
				if(arr[i-1] == arr[i]) {
					cnt++;
					if(maxCnt < cnt) {
						maxCnt = cnt;
						arraylist.clear();
						arraylist.add(arr[i]);
					}
					else if(maxCnt == cnt) {
						arraylist.add(arr[i]);
					}
				}else {
					cnt = 1;
					if(maxCnt == cnt) {
						arraylist.add(arr[i]);
					}
				}
			}
			
			if(arraylist.size() == 1) {
				bw.write(Integer.toString(arraylist.get(0)));
			}else {
				bw.write(Integer.toString(arraylist.get(1)));
			}
			bw.newLine();

			//넷째 줄에는 범위를 출력한다.
			bw.write(Integer.toString(arr[n-1] - arr[0]));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
