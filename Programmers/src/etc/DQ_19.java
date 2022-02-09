package etc;

import java.io.*;
import java.util.*;

public class DQ_19 {

	BufferedReader br;
	BufferedWriter bw;
	ArrayList<String> allOp;
	
	public static void main(String[] args) {
		
		DQ_19 dq = new DQ_19();
		
		dq.sol();
	}
	
	public void sol() { // 연산자 끼워 넣기
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			// 원본 연산자 만들기
			String op = "";
			s = br.readLine().split(" ");
			for(int i = 0; i < 4; i++) {
				int opN = Integer.parseInt(s[i]);
				for(int j = 0; j < opN; j++) {
					if(i == 0) {
						op += "+";
					}else if(i == 1) {
						op += "-";
					}else if(i == 2) {
						op += "x";
					}else {
						op += "/";
					}
				}
			}
			
			// 가능한 연산자 순열 찾기
			allOp = new ArrayList<>();
			boolean[] visited = new boolean[n-1];
			perm(op, visited, 0, "");
			
			// 계산하기
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void perm(String op, boolean[] visited, int depth, String tmp) {
		
		if(depth == op.length()) {
			allOp.add(tmp);
			System.out.println(tmp);
			return;
		}
		
		for(int i = 0; i < op.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm(op, visited, depth+1, tmp+op.substring(i,i+1));
				visited[i] = false;
			}
		}
	}
}
