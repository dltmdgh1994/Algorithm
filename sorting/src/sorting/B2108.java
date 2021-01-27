package sorting;

import java.io.*;
import java.util.ArrayList;

class B2108 { // �����
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
			
			//ù° �ٿ��� �������� ����Ѵ�. �Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.
			bw.write(Integer.toString((int)Math.round((double)sum / n)));
			bw.newLine();

			//��° �ٿ��� �߾Ӱ��� ����Ѵ�.
			bw.write(Integer.toString(arr[((n+1)/2) -1]));
			bw.newLine();
			
			//��° �ٿ��� �ֺ��� ����Ѵ�. ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.
//			boolean flag = false;
//			int mode_max = 0;
//			int mode = 10000;
//			
//			for(int i = 0; i < n; i++) {
//				int jump = 0;	// ������ ���� ���¸�ŭ i �� jump ��ų ���� 
//				int count = 1;
//				int i_value = arr[i];
//				
//				for(int j = i + 1; j < n; j++){
//					if(i_value != arr[j]) {
//						break;
//					}
//					count++;
//					jump++;
//				}
//				
//				if(count > mode_max) {
//					mode_max = count;
//					mode = i_value;
//					flag = true;
//				}
//				else if(count == mode_max && flag == true) {
//					mode = i_value;
//					flag = false;
//				}
//				
//				i += jump;
//			}
//			bw.write(Integer.toString(mode));
//			bw.newLine();
			
			int val = arr[0];
			int maxCnt = 1; int cnt = 1;  boolean flag = true;
			
			for(int i = 1; i < n; i++) {
				if(arr[i-1] == arr[i]) { // ���� ���
					cnt++;
					if(maxCnt < cnt) {
						maxCnt = cnt;
						val = arr[i];
						flag = true;
					}
					else if(maxCnt == cnt && flag == true) {
						val = arr[i];
						flag = false;
					}
				}else { // �ٸ� ���
					cnt = 1;
					if(maxCnt == cnt && flag == true) {
						val = arr[i];
						flag = false;
					}
				}
			}
			
			bw.write(Integer.toString(val));
			bw.newLine();


			//��° �ٿ��� ������ ����Ѵ�.
			bw.write(Integer.toString(arr[n-1] - arr[0]));
			bw.newLine();
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
