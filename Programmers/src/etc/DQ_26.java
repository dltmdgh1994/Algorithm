package etc;

import java.io.*;
import java.util.*;

public class DQ_26 { // 카드 정렬하기

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_26 dq = new DQ_26();
		
		dq.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0; i < n; i++) {
				pq.add(Integer.parseInt(br.readLine()));
			}
			
			int answer = 0;
			
			while(pq.size() != 1) {
				int o1 = pq.poll();
				int o2 = pq.poll();
				
				int sum = o1+o2;
				answer += sum;
				pq.add(sum);
			}
			
			bw.write(Integer.toString(answer));
					
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
