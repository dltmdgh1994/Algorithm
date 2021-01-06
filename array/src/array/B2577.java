package array;

import java.io.*;

class B2577 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int arr[] = new int[3];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			int num = arr[0] * arr[1] * arr[2];
			int len = (int)(Math.log10(num)+1); //num의 자릿수

			int n[] = new int[10]; 
			for(int i = 0; i < n.length; i++) {
				n[i] = 0;
			}
			
			int z; int front;  //0~9 숫자 세기
			for(int i = len-1; i >= 0; i--) {
				z = (int)Math.pow(10, i); //자바는 ^ 대신 Math.pow(밑,지수)
				front = num / z;
				num = (num % z);
				if(front == 0) {
					n[0]++;
				}
				else if(front == 1) {
					n[1]++;
				}
				else if(front == 2) {
					n[2]++;
				}
				else if(front == 3) {
					n[3]++;
				}
				else if(front == 4) {
					n[4]++;
				}
				else if(front == 5) {
					n[5]++;
				}
				else if(front == 6) {
					n[6]++;
				}
				else if(front == 7) {
					n[7]++;
				}
				else if(front == 8) {
					n[8]++;
				}
				else if(front == 9) {
					n[9]++;
				}
			}
			
			//출력
			for(int i =0; i < n.length; i++) {
				bw.write(Integer.toString(n[i]));
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
