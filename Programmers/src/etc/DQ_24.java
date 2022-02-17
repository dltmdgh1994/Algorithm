package etc;

import java.io.*;
import java.util.*;

public class DQ_24 { // ¾ÈÅ×³ª

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_24 dq = new DQ_24();
		
		dq.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[][] arr = new int[n][2];
			for(int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(s[i]);
			}
			
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = 0; j < n; j++) {
					sum += Math.abs(arr[i][0]-arr[j][0]);
				}
				arr[i][1] = sum;
			}
			
			Arrays.sort(arr,(o1,o2)->{
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}else {
					return Integer.compare(o1[1], o2[1]);
				}
			});
			
			bw.write(Integer.toString(arr[0][0]));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
